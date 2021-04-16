package com.example.modularization.cart_domain_read_api.models

import com.example.modularization.app_api.aliases.Sku

data class Cart(
    val products: List<CartProduct>
)

data class CartProduct(
    val sku: Sku,
    val positionId: Int,
)
