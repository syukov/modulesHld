package com.example.modularization.core_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.moduleApi.CoreDomainApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface CoreDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindCoreDomainApi(impl: CoreDomainApiImpl): CoreDomainApi
}