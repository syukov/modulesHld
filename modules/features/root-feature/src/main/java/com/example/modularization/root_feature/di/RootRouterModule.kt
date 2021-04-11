package com.example.modularization.root_feature.di

import com.example.modularization.employee_auth_feature.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature.screens.login.LoginFragment
import com.example.modularization.main_feature.screens.main.MainFragment
import com.example.modularization.root_feature.router.RootRouterImpl
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import com.example.modularization.ui_core.utils.checkWhenBranches
import dagger.Module
import dagger.Provides

@Module
interface RootRouterModule {

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
                    ?: throw UnsupportedOperationException("$fragmentName should be registered in ${RootRouterModule::class.simpleName} to be opened in RootRouter")
            }
        }

        @PerFeatureScope
        @Provides
        fun provideRootRouter(): RootRouter = rootRouterImpl
    }
}