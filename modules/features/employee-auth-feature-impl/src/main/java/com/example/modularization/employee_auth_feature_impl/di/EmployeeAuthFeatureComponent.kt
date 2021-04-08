package com.example.modularization.employee_auth_feature_impl.di

import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [EmployeeAuthFeatureLauncher.Dependencies::class],
    modules = [
        EmployeeAuthFeatureModule::class
    ]
)
@PerFeatureScope
interface EmployeeAuthFeatureComponent : EmployeeAuthFeatureLauncher.ComponentApi {

    fun inject(fragment: LoginFragment)
    fun inject(fragment: DebugToolsFragment)

    @Component.Factory
    interface ComponentFactory : EmployeeAuthFeatureLauncher.ComponentFactoryApi {
        override fun create(dependencies: EmployeeAuthFeatureLauncher.Dependencies): EmployeeAuthFeatureComponent
    }
}