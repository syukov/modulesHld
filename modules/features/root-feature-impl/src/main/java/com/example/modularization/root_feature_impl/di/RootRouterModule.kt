package com.example.modularization.root_feature_impl.di

import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import com.example.modularization.main_feature_impl.screens.main.MainFragment
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.root_feature_impl.router.RootRouterImpl
import com.example.modularization.ui_core.di.PerFeatureScope
import com.example.modularization.ui_core.utils.checkWhenBranches
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
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

        @PerFeatureScope
        @Provides
        fun provideRootRouterNavigatorHolder(): NavigatorHolder {
            return Cicerone.create(rootRouterImpl).getNavigatorHolder()
        }
    }
}