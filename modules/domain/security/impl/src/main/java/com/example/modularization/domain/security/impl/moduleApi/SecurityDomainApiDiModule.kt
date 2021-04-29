package com.example.modularization.domain.security.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import dagger.Binds
import dagger.Module

@Module
interface SecurityDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: SecurityDomainApiImpl): SecurityDomainApi
}