package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain.useCase.GetCart
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
@Doc.Api.Implementation
class CartDomainReadApiImpl @Inject constructor(
    private val getCartProvider: Provider<GetCart>,
) : CartDomainReadApi {
    override val getCart: GetCart get() = getCartProvider.get()
}