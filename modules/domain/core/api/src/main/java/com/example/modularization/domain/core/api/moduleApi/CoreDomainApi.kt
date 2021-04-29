package com.example.modularization.domain.core.api.moduleApi

import com.example.modularization.domain.core.api.models.domainEvents.DomainEventsBus


interface CoreDomainApi {
    val domainEventBus: DomainEventsBus
}