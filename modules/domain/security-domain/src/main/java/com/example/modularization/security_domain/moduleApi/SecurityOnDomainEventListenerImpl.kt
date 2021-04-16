package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_domain_api.models.domainEvents.DomainEvent
import com.example.modularization.core_domain_api.models.domainEvents.OnDomainEventListener
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