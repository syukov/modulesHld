package com.example.modularization.domain.core.api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.models.domainEvents.DomainEventsBus

@Doc.Api
interface CoreDomainApi {
    val domainEventBus: DomainEventsBus
}