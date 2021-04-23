package com.example.modularization.domain.core.impl.domainEvents

import com.example.modularization.domain.core.api.models.domainEvents.DomainEvent
import com.example.modularization.domain.core.api.models.domainEvents.DomainEventsBus
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import javax.inject.Inject

class DomainEventsBusImpl @Inject constructor() : DomainEventsBus {

    private val listeners: MutableList<OnDomainEventListener> = mutableListOf()

    override fun pushEvent(event: DomainEvent) {
        listeners.forEach { it.onEvent(event) }
    }

    override fun subscribe(vararg listener: OnDomainEventListener) {
        listeners += listener
    }
}