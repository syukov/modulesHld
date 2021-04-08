package com.example.modularization.employee_auth_feature_impl.di

import com.example.modularization.employee_auth_feature_impl.EmployeeAuthFeatureFragmentProvider
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface EmployeeAuthFeatureModule {

    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: EmployeeAuthFeatureFragmentProvider): EmployeeAuthFeatureLauncher.FragmentProvider
}