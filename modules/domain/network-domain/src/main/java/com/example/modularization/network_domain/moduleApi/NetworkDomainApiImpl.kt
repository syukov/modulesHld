package com.example.modularization.network_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain_api.models.Retrofit
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import javax.inject.Inject

@ApplicationScope
@DiDoc.Api.Implementation
class NetworkDomainApiImpl @Inject constructor(
    override val retrofit: Retrofit
) : NetworkDomainApi