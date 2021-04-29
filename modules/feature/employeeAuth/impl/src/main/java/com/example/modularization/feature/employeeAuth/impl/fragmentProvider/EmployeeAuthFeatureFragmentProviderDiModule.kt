package com.example.modularization.feature.employeeAuth.impl.fragmentProvider

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface EmployeeAuthFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: EmployeeAuthFeatureFragmentProviderImpl): EmployeeAuthFeatureFragmentProvider
}