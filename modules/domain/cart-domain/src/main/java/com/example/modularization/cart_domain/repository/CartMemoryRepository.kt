package com.example.modularization.cart_domain.repository

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.cart_domain_api.models.Cart
import com.example.modularization.core_domain.repository.BaseMemoryRepository
import javax.inject.Inject

@ApplicationScope
class CartMemoryRepository @Inject constructor(
) : BaseMemoryRepository() {
    var cart: Cart? = null
}