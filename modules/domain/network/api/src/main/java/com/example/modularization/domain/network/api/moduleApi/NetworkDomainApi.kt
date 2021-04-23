package com.example.modularization.domain.network.api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.network.api.models.Retrofit


@Doc.Api
interface NetworkDomainApi {
    val retrofit: Retrofit
}