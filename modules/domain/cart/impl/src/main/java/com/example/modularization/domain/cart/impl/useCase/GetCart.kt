package com.example.modularization.domain.cart.impl.useCase

import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.domain.cart.impl.repository.CartMemoryRepository
import com.example.modularization.domain.core.api.UseCase
import javax.inject.Inject

class GetCart @Inject constructor(
    private val cartMemoryRepository: CartMemoryRepository
) : UseCase<Unit, Cart> {
    override fun invoke(arg: Unit): Cart {
        return cartMemoryRepository.cart ?: Cart(products = emptyList())
    }
}