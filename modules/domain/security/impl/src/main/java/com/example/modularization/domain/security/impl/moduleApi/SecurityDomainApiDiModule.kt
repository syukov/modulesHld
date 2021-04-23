package com.example.modularization.domain.security.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface SecurityDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: SecurityDomainApiImpl): SecurityDomainApi
}