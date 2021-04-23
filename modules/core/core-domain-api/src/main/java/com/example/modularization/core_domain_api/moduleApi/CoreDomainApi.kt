package com.example.modularization.core_domain_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.models.domainEvents.DomainEventsBus

@Doc.Api
interface CoreDomainApi {
    val domainEventBus: DomainEventsBus
}