package com.example.modularization.cart_domain.useCase

import com.example.modularization.app_api.aliases.Sku
import com.example.modularization.cart_domain.repository.CartMemoryRepository
import com.example.modularization.cart_domain.repository.CartRemoteRepository
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.cart_domain_read_api.models.CartProduct
import com.example.modularization.core_domain_api.UseCase
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