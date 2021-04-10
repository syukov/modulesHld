package com.example.modularization.employee_auth_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature.screens.login.LoginFragment
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface EmployeeAuthFeatureModule {
    companion object {
        @PerFeatureScope
        @Provides
        fun provideFragmentProvider(
            loginFragment: Provider<LoginFragment>,
            debugToolsFragment: Provider<DebugToolsFragment>,
        ): EmployeeAuthFeatureComponent.FragmentProvider {
            return object : EmployeeAuthFeatureComponent.FragmentProvider {
                override fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment {
                    return when (screen) {
                        RootRouter.Screen.EmployeeAuthFeature.Login -> loginFragment.get()
                        RootRouter.Screen.EmployeeAuthFeature.DebugTools -> debugToolsFragment.get()
                    }
                }
            }
        }
    }
}