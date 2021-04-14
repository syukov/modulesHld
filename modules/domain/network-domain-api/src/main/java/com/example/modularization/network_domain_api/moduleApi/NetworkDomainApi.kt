package com.example.modularization.network_domain_api.moduleApi

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain_api.models.Retrofit


@DiDoc.Api
interface NetworkDomainApi {
    val retrofit: Retrofit
}