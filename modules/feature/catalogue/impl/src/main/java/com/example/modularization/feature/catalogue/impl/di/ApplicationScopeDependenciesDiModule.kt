package com.example.modularization.feature.catalogue.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @Provides
    fun appDomainApi(): AppDomainApi = ApplicationScopeServiceLocator.get(AppDomainApi::class.java)

    @Provides
    fun securityDomainApi(): SecurityDomainApi = ApplicationScopeServiceLocator.get(SecurityDomainApi::class.java)
}