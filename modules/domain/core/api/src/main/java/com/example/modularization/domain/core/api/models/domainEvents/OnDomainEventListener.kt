package com.example.modularization.domain.core.api.models.domainEvents

interface OnDomainEventListener {
    fun onEvent(event: DomainEvent)
}