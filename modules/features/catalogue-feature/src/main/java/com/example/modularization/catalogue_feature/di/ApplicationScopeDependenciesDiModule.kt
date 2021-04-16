package com.example.modularization.catalogue_feature.di

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {

    @Provides
    fun appDomainApi(): AppDomainApi = ApplicationScopeApiHolder.get(AppDomainApi::class.java)

    @Provides
    fun securityDomainApi(): SecurityDomainApi = ApplicationScopeApiHolder.get(SecurityDomainApi::class.java)
}