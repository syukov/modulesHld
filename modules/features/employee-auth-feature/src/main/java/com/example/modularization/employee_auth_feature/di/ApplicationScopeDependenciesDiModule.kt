package com.example.modularization.employee_auth_feature.di

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
@DiDoc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @PerFeatureScope
    @Provides
    fun provideSecurityDomainApi(): SecurityDomainApi {
        return ApplicationScopeApiHolder.get(SecurityDomainApi::class.java)
    }
}