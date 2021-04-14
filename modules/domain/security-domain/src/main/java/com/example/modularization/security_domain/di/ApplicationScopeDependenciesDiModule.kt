package com.example.modularization.security_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Module
import dagger.Provides

@Module
@DiDoc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    @ApplicationScope
    fun networkDomainApi(
    ): NetworkDomainApi {
        return ApplicationScopeApiHolder.get(NetworkDomainApi::class.java)
    }
}