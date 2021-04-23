package com.example.modularization.domain.core.impl.domainEvents

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.models.domainEvents.DomainEventsBus
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface DomainEventBusDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainEventBus(impl: DomainEventsBusImpl): DomainEventsBus
}