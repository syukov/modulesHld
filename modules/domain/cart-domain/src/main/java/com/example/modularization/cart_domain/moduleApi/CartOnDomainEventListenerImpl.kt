package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.cart_domain.useCase.ClearCart
import com.example.modularization.core_domain_api.models.domainEvents.DomainEvent
import com.example.modularization.core_domain_api.models.domainEvents.OnDomainEventListener
import javax.inject.Inject

@ApplicationScope
@Doc.Api.Implementation
class CartOnDomainEventListenerImpl @Inject constructor(
    private val clearCart: ClearCart
) : OnDomainEventListener {
    override fun onEvent(event: DomainEvent) {
        when (event) {
            DomainEvent.OnEmployeeLogout -> clearCart(Unit)
        }
    }
}