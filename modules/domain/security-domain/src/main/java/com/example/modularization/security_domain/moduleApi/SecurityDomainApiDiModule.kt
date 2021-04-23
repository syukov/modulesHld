package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface SecurityDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: SecurityDomainApiImpl): SecurityDomainApi
}