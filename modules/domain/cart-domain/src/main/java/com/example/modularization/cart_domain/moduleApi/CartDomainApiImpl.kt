package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_domain.moduleApi.useCase.AddProduct
import com.example.modularization.cart_domain.moduleApi.useCase.ClearCart
import com.example.modularization.cart_domain.moduleApi.useCase.GetCart
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import javax.inject.Inject

@ApplicationScope
@DiDoc.Api.Implementation
class CartDomainApiImpl @Inject constructor(
    override val addProduct: AddProduct,
    override val getCart: GetCart,
    override val clearCart: ClearCart,
) : CartDomainApi