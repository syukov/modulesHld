package com.example.modularization.cart_domain_read_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.domain.core.api.UseCase

@Doc.Api
interface CartDomainReadApi {
    val getCart: UseCase<Unit, Cart>
}