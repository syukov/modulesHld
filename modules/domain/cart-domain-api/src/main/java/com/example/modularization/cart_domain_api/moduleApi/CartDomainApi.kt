package com.example.modularization.cart_domain_api.moduleApi

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import com.example.modularization.domain.core.api.UseCase

@Doc.Api
interface CartDomainApi : CartDomainReadApi {
    // inherited from DomainReadApi:
    override val getCart: UseCase<Unit, Cart>

    // not idempotent use cases:
    val addProduct: UseCase<Sku, Unit>
    val clearCart: UseCase<Unit, Unit>
}