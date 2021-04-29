package com.example.modularization.domain.network.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import dagger.Binds
import dagger.Module


@Module
interface NetworkDomainApiDiModule {
    @Binds
    @ApplicationScope
    fun bindNetworkDomainApi(impl: NetworkDomainApiImpl): NetworkDomainApi
}