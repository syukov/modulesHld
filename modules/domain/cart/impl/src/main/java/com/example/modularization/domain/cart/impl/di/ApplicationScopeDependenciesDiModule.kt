package com.example.modularization.domain.cart.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
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