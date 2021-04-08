package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject
import javax.inject.Provider

class RootRouterFragmentResolver @Inject constructor(
    private val employeeAuthFeatureComponentApiProvider: Provider<EmployeeAuthFeatureLauncher.ComponentApi>,
    private val mainFeatureComponentApiProvider: Provider<MainFeatureLauncher.ComponentApi>,
) {
    fun getFragmentByScreen(screen: RootRouter.Screen): Fragment {
        return when (screen) {
            is RootRouter.Screen.EmployeeAuthFeature -> {
                val component = employeeAuthFeatureComponentApiProvider.get()
                component.getFragmentProvider().getFragment(screen)
            }
            is RootRouter.Screen.MainFeature -> {
                val component = mainFeatureComponentApiProvider.get()
                component.getFragmentProvider().getFragment(screen)
            }
        }
    }
}