package com.example.modularization.employee_auth_feature_impl.di

import com.example.modularization.employee_auth_feature_api.fature.EmployeeAuthFeatureContract
import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import dagger.Component

@Component(
    dependencies = [EmployeeAuthFeatureContract.Dependencies::class]
)
interface EmployeeAuthFeatureComponent : EmployeeAuthFeatureContract.Component {

    fun inject(fragment: LoginFragment)
    fun inject(fragment: DebugToolsFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(deps: EmployeeAuthFeatureContract.Dependencies): EmployeeAuthFeatureComponent
    }
}