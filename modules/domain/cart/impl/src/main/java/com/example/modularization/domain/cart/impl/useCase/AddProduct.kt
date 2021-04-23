package com.example.modularization.domain.cart.impl.useCase

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.cart_domain_read_api.models.CartProduct
import com.example.modularization.domain.cart.impl.repository.CartMemoryRepository
import com.example.modularization.domain.cart.impl.repository.CartRemoteRepository
import com.example.modularization.domain.core.api.UseCase
import javax.inject.Inject
import kotlin.random.Random

class AddProduct @Inject constructor(
    private val cartRemoteRepository: CartRemoteRepository,
    private val cartMemoryRepository: CartMemoryRepository
) : UseCase<Sku, Unit> {
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun invoke(sku: Sku): Unit {
        cartRemoteRepository.addProduct(sku)
        val oldProducts = cartMemoryRepository.cart?.products ?: emptyList()
        cartMemoryRepository.cart = Cart(oldProducts + CartProduct(sku, Random.nextInt()))
    }
}