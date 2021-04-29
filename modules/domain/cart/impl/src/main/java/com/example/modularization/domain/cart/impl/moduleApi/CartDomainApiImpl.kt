package com.example.modularization.domain.cart.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.domain.cart.impl.useCase.AddProduct
import com.example.modularization.domain.cart.impl.useCase.ClearCart
import com.example.modularization.domain.cart.impl.useCase.GetCart
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope

class CartDomainApiImpl @Inject constructor(
    private val getCartProvider: Provider<GetCart>,
    private val addProductProvider: Provider<AddProduct>,
    private val clearCartProvider: Provider<ClearCart>,
) : CartDomainApi {
    override val getCart: GetCart get() = getCartProvider.get()
    override val addProduct: AddProduct get() = addProductProvider.get()
    override val clearCart: ClearCart get() = clearCartProvider.get()
}