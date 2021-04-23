package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain.useCase.AddProduct
import com.example.modularization.cart_domain.useCase.ClearCart
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
@Doc.Api.Implementation
class CartDomainApiImpl @Inject constructor(
    private val readApi: CartDomainReadApi,

    private val addProductProvider: Provider<AddProduct>,
    private val clearCartProvider: Provider<ClearCart>,
) : CartDomainApi {
    override val getCart get() = readApi.getCart

    override val addProduct: AddProduct get() = addProductProvider.get()
    override val clearCart: ClearCart get() = clearCartProvider.get()
}