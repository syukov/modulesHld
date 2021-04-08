package com.example.modularization.app_feature_impl.di.routerScreenToNameMappers

import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import com.example.modularization.main_feature_impl.screens.main.MainFragment
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject

class RootRouterScreenToNameMapper @Inject constructor() : RootRouter.ScreenToNameMapper {
    override fun getFragmentName(key: RootRouter.Screen): String {
        return when (key) {
            is RootRouter.Screen.EmployeeAuthFeature -> {
                when (key) {
                    RootRouter.Screen.EmployeeAuthFeature.Login -> LoginFragment::class.java.name
                    RootRouter.Screen.EmployeeAuthFeature.DebugTools -> DebugToolsFragment::class.java.name
                }
            }
            is RootRouter.Screen.MainFeature -> {
                when (key) {
                    is RootRouter.Screen.MainFeature.Main -> MainFragment::class.java.name
                }
            }
        }
    }
}

