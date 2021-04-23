package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface CartOnDomainEventDiModule {
    @ApplicationScope
    @Binds
    fun bindOnDomainEventListener(impl: CartOnDomainEventListenerImpl): OnDomainEventListener
}