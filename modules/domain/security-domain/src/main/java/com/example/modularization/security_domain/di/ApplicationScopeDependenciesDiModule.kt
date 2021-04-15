package com.example.modularization.security_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Module
import dagger.Provides

@Module
@DiDoc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    @ApplicationScope
    fun networkDomainApi(): NetworkDomainApi = ApplicationScopeApiHolder.get(NetworkDomainApi::class.java)

    @Provides
    @ApplicationScope
    fun cartDomainApi(): CartDomainApi = ApplicationScopeApiHolder.get(CartDomainApi::class.java)
}