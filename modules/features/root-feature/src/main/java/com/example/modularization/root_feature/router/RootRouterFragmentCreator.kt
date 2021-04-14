package com.example.modularization.root_feature.router

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature.di.EmployeeAuthFeatureDi
import com.example.modularization.main_feature.di.MainFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.navigation.CiceroneScreen
import com.example.modularization.ui_core.navigation.RouterFragmentCreator
import javax.inject.Inject
import javax.inject.Provider

class RootRouterFragmentCreator @Inject constructor(
    private val employeeAuthFeatureComponentProvider: Provider<EmployeeAuthFeatureDi.DiComponent>,
    private val mainFeatureComponentApiProvider: Provider<MainFeatureDi.DiComponent>,
) : RouterFragmentCreator {
    override fun getFragmentByScreen(screen: CiceroneScreen): Fragment {
        if (screen !is RootRouter.Screen) throw UnsupportedOperationException("Root router is able to open only RootRouter.Screen but not ${screen::class.java.name}")
        return when (screen) {
            is RootRouter.Screen.EmployeeAuthFeature -> {
                val component = employeeAuthFeatureComponentProvider.get()
                component.fragmentProvider.getFragment(screen)
            }
            is RootRouter.Screen.MainFeature -> {
                val component = mainFeatureComponentApiProvider.get()
                component.fragmentProvider.getFragment(screen)
            }
        }
    }
}