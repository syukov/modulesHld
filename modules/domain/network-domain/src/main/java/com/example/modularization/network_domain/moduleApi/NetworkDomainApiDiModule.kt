package com.example.modularization.network_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Binds
import dagger.Module

@DiDoc.Api.DiModule
@Module
interface NetworkDomainApiDiModule {
    @Binds
    @ApplicationScope
    fun bindNetworkDomainApi(impl: NetworkDomainApiImpl): NetworkDomainApi
}