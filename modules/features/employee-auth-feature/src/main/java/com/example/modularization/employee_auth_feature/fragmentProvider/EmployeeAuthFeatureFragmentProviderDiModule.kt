package com.example.modularization.employee_auth_feature.fragmentProvider

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface EmployeeAuthFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: EmployeeAuthFeatureFragmentProviderImpl): EmployeeAuthFeatureFragmentProvider
}