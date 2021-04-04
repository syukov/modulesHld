package com.example.modularization.app_feature_impl.di.screenToNameMapper

import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import javax.inject.Inject

class AppRouterScreenToNameMapper @Inject constructor() : AppRouter.ScreenToNameMapper {
    override fun getFragmentName(key: AppRouter.Screen): String {
        return when (key) {
            AppRouter.Screen.EmployeeAuthFeature.Login -> LoginFragment::class.java.name
            AppRouter.Screen.EmployeeAuthFeature.DebugTools -> DebugToolsFragment::class.java.name
        }
    }
}