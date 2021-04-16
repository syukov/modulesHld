package com.example.modularization.core_domain.moduleApi

import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_domain_api.models.domainEvents.DomainEventsBus
import com.example.modularization.core_domain_api.moduleApi.CoreDomainApi
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class CoreDomainApiImpl @Inject constructor(
    private val domainEventBusProvider: Provider<DomainEventsBus>
) : CoreDomainApi {
    override val domainEventBus: DomainEventsBus get() = domainEventBusProvider.get()
}