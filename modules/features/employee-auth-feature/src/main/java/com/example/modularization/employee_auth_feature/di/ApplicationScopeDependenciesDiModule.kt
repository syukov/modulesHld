package com.example.modularization.employee_auth_feature.di

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @PerFeatureScope
    @Provides
    fun provideSecurityDomainApi(): SecurityDomainApi {
        return ApplicationScopeApiHolder.get(SecurityDomainApi::class.java)
    }
}