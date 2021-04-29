package com.example.modularization.domain.cart.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.cart.impl.useCase.ClearCart
import com.example.modularization.domain.core.api.models.domainEvents.DomainEvent
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import javax.inject.Inject

@ApplicationScope
class CartOnDomainEventListenerImpl @Inject constructor(
    private val clearCart: ClearCart
) : OnDomainEventListener {
    override fun onEvent(event: DomainEvent) {
        when (event) {
            DomainEvent.OnEmployeeLogout -> clearCart(Unit)
        }
    }
}