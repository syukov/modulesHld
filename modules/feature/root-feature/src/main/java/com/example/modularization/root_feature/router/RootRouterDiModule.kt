package com.example.modularization.root_feature.router

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_feature.utils.checkWhenBranches
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.employeeAuth.impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.feature.employeeAuth.impl.screens.login.LoginFragment
import com.example.modularization.feature.main.impl.screens.main.MainFragment
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
@Doc.Api.DiModule
interface RootRouterDiModule {

    companion object {
        private val rootRouterImpl = RootRouterImpl()

        /**
         * Хук с рефлексией для того что бы компилятор нам подсказал если мы создали Screen и забыли указать ему имя фрагмента
         */
        private val fragmentsMap: Map<String, RootRouter.Screen> = mutableMapOf<String, RootRouter.Screen>().apply {
            RootRouter.Screen::class.sealedSubclasses
                .mapNotNull { it.objectInstance }
                .forEach {
                    when (it) {
                        RootRouter.Screen.EmployeeAuthFeature.Login -> put(LoginFragment::class.java.name, it)
                        RootRouter.Screen.EmployeeAuthFeature.DebugTools -> put(DebugToolsFragment::class.java.name, it)
                        RootRouter.Screen.MainFeature.Main -> put(MainFragment::class.java.name, it)
                    }.checkWhenBranches
                }
        }


        @PerFeatureScope
        @Provides
        fun provideFragmentFeatureResolver() = object : RootRouter.ScreensResolver {
            override fun getScreenByFragmentName(fragmentName: String): RootRouter.Screen {
                return fragmentsMap[fragmentName]
                    ?: throw UnsupportedOperationException("$fragmentName should be registered in ${RootRouterDiModule::class.simpleName} to be opened in RootRouter")
            }
        }

        @PerFeatureScope
        @Provides
        fun provideRootRouter(): RootRouter = rootRouterImpl
    }
}