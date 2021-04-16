package com.example.modularization.core_domain_api.models.domainEvents

interface DomainEventsBus {
    fun pushEvent(event: DomainEvent)

    fun subscribe(vararg listener: OnDomainEventListener)
}