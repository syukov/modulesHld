package com.example.modularization.network_domain_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.network_domain_api.models.Retrofit


@Doc.Api
interface NetworkDomainApi {
    val retrofit: Retrofit
}