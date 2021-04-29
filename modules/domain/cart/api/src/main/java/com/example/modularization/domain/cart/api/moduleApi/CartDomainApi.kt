package com.example.modularization.domain.cart.api.moduleApi

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.domain.core.api.UseCase


interface CartDomainApi {
    val getCart: UseCase<Unit, Cart>
    val addProduct: UseCase<Sku, Unit>
    val clearCart: UseCase<Unit, Unit>
}