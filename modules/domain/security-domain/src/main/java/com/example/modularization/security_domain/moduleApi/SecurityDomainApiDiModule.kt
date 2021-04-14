package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Binds
import dagger.Module

@Module
@DiDoc.Api.DiModule
interface SecurityDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: SecurityDomainApiImpl): SecurityDomainApi
}