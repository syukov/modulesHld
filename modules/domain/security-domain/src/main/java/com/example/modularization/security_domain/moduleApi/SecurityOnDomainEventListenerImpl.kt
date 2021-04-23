package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.models.domainEvents.DomainEvent
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import javax.inject.Inject

@ApplicationScope
@Doc.Api.Implementation
class SecurityOnDomainEventListenerImpl @Inject constructor(
) : OnDomainEventListener {
    override fun onEvent(event: DomainEvent) {
        when (event) {
            DomainEvent.OnEmployeeLogout -> return
        }
    }
}