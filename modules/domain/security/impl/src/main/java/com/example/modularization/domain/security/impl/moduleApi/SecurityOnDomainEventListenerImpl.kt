package com.example.modularization.domain.security.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.api.models.domainEvents.DomainEvent
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import javax.inject.Inject

@ApplicationScope
class SecurityOnDomainEventListenerImpl @Inject constructor(
) : OnDomainEventListener {
    override fun onEvent(event: DomainEvent) {
        when (event) {
            DomainEvent.OnEmployeeLogout -> return
        }
    }
}