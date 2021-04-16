package com.example.modularization.core_domain_api.models.domainEvents

interface OnDomainEventListener {
    fun onEvent(event: DomainEvent)
}