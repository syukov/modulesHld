package com.example.modularization.domain.core.api.models.domainEvents

interface DomainEventsBus {
    fun pushEvent(event: DomainEvent)

    fun subscribe(vararg listener: OnDomainEventListener)
}