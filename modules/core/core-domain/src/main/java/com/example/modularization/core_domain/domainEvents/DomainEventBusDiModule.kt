package com.example.modularization.core_domain.domainEvents

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.models.domainEvents.DomainEventsBus
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface DomainEventBusDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainEventBus(impl: DomainEventsBusImpl): DomainEventsBus
}