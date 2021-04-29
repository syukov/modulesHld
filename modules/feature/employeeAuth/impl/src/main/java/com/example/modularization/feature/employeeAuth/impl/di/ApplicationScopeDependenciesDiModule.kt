package com.example.modularization.feature.employeeAuth.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @PerFeatureScope
    @Provides
    fun provideSecurityDomainApi(): SecurityDomainApi {
        return ApplicationScopeServiceLocator.get(SecurityDomainApi::class.java)
    }
}