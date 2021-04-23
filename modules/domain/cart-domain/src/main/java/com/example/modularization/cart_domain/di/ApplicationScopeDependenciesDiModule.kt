package com.example.modularization.cart_domain.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.moduleApi.CoreDomainApi
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    @ApplicationScope
    fun coreDomainApi(): CoreDomainApi = ApplicationScopeApiHolder.get(CoreDomainApi::class.java)

    @Provides
    @ApplicationScope
    fun networkDomainApi(
    ): NetworkDomainApi = ApplicationScopeApiHolder.get(NetworkDomainApi::class.java)
}