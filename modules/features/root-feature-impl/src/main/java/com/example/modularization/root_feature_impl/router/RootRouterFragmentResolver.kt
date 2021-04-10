package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature_impl.di.EmployeeAuthFeatureComponent
import com.example.modularization.main_feature_impl.di.MainFeatureComponent
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject
import javax.inject.Provider

class RootRouterFragmentResolver @Inject constructor(
    private val employeeAuthFeatureComponentProvider: Provider<EmployeeAuthFeatureComponent>,
    private val mainFeatureComponentApiProvider: Provider<MainFeatureComponent>,
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