package com.example.modularization.network_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.network_domain_api.models.Retrofit
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
@Doc.Api.Implementation
class NetworkDomainApiImpl @Inject constructor(
    private val retrofitProvider: Provider<Retrofit>
) : NetworkDomainApi {
    override val retrofit: Retrofit get() = retrofitProvider.get()
}