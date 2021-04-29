package com.example.modularization.feature.catalogue.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @Provides
    fun appDomainApi(): AppDomainApi = ApplicationScopeApiHolder.get(AppDomainApi::class.java)

    @Provides
    fun securityDomainApi(): SecurityDomainApi = ApplicationScopeApiHolder.get(SecurityDomainApi::class.java)
}