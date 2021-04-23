package com.example.modularization.domain.core.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface CoreDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindCoreDomainApi(impl: CoreDomainApiImpl): CoreDomainApi
}