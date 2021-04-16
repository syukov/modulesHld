package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_domain_api.models.domainEvents.OnDomainEventListener
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface SecurityOnDomainEventListenerDiModule {
    @ApplicationScope
    @Binds
    fun bindOnDomainEventListener(impl: SecurityOnDomainEventListenerImpl): OnDomainEventListener
}