package com.example.modularization.cart_domain.moduleApi.useCase

import com.example.modularization.cart_domain.repository.CartMemoryRepository
import com.example.modularization.cart_domain_api.models.Cart
import com.example.modularization.core_domain_api.UseCase
import javax.inject.Inject

class ClearCart @Inject constructor(
    private val cartMemoryRepository: CartMemoryRepository
) : UseCase<Unit, Unit> {
    override fun invoke(arg: Unit): Unit {
        cartMemoryRepository.cart = Cart(products = emptyList())
    }
}