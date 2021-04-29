package com.example.modularization.domain.cart.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @Provides
    @ApplicationScope
    fun coreDomainApi(): CoreDomainApi = ApplicationScopeServiceLocator.get(CoreDomainApi::class.java)

    @Provides
    @ApplicationScope
    fun networkDomainApi(
    ): NetworkDomainApi = ApplicationScopeServiceLocator.get(NetworkDomainApi::class.java)
}