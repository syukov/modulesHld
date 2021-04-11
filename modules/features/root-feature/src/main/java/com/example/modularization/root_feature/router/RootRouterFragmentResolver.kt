package com.example.modularization.root_feature.router

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature.di.EmployeeAuthFeatureDi
import com.example.modularization.main_feature.di.MainFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import javax.inject.Inject
import javax.inject.Provider

class RootRouterFragmentResolver @Inject constructor(
    private val employeeAuthFeatureComponentProvider: Provider<EmployeeAuthFeatureDi.FeatureComponent>,
    private val mainFeatureComponentApiProvider: Provider<MainFeatureDi.FeatureComponent>,
) {
    fun getFragmentByScreen(screen: RootRouter.Screen): Fragment {
        return when (screen) {
            is RootRouter.Screen.EmployeeAuthFeature -> {
                val component = employeeAuthFeatureComponentProvider.get()
                component.getFragmentProvider().getFragment(screen)
            }
            is RootRouter.Screen.MainFeature -> {
                val component = mainFeatureComponentApiProvider.get()
                component.getFragmentProvider().getFragment(screen)
            }
        }
    }
}