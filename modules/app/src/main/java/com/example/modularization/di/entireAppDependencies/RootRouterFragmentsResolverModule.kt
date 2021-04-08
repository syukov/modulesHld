package com.example.modularization.di.entireAppDependencies

import com.example.modularization.di.PerApplicationScope
import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import com.example.modularization.main_feature_impl.screens.main.MainFragment
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.utils.checkWhenBranches
import dagger.Module
import dagger.Provides

@Module
class RootRouterFragmentsResolverModule {
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


    @PerApplicationScope
    @Provides
    fun provideFragmentFeatureResolver() = object : RootRouter.ScreensResolver {
        override fun getScreenByFragmentName(fragmentName: String): RootRouter.Screen {
            return fragmentsMap[fragmentName]
                ?: throw UnsupportedOperationException("$fragmentName should be registered in ${RootRouterFragmentsResolverModule::class.simpleName} to be opened in RootRouter")
        }
    }
}

