package com.example.modularization.domain.core.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import dagger.Binds
import dagger.Module

@Module
interface CoreDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindCoreDomainApi(impl: CoreDomainApiImpl): CoreDomainApi
}