package com.example.modularization.cart_domain_api.moduleApi

import com.example.modularization.app_api.aliases.Sku
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_domain_api.models.Cart
import com.example.modularization.core_domain_api.UseCase

@DiDoc.Api
interface CartDomainApi {
    val addProduct: UseCase<Sku, Unit>
    val getCart: UseCase<Unit, Cart>
    val clearCart: UseCase<Unit, Unit>
}