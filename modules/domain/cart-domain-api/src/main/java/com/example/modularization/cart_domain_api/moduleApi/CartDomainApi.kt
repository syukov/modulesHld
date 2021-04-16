package com.example.modularization.cart_domain_api.moduleApi

import com.example.modularization.app_api.aliases.Sku
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import com.example.modularization.core_domain_api.UseCase

@Doc.Api
interface CartDomainApi : CartDomainReadApi {
    // inherited from DomainReadApi:
    override val getCart: UseCase<Unit, Cart>

    // not idempotent use cases:
    val addProduct: UseCase<Sku, Unit>
    val clearCart: UseCase<Unit, Unit>
}