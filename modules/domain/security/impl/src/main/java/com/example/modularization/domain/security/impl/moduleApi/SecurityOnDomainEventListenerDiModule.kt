package com.example.modularization.domain.security.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import dagger.Binds
import dagger.Module

@Module
interface SecurityOnDomainEventListenerDiModule {
    @ApplicationScope
    @Binds
    fun bindOnDomainEventListener(impl: SecurityOnDomainEventListenerImpl): OnDomainEventListener
}