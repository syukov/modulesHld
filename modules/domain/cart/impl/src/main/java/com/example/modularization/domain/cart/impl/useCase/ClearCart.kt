package com.example.modularization.domain.cart.impl.useCase

import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.domain.cart.impl.repository.CartMemoryRepository
import com.example.modularization.domain.core.api.UseCase
import javax.inject.Inject

class ClearCart @Inject constructor(
    private val cartMemoryRepository: CartMemoryRepository
) : UseCase<Unit, Unit> {
    override fun invoke(arg: Unit): Unit {
        cartMemoryRepository.cart = Cart(products = emptyList())
    }
}