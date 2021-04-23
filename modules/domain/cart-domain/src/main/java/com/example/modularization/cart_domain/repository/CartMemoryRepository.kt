package com.example.modularization.cart_domain.repository

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.cart_domain_read_api.models.Cart
import com.example.modularization.domain.core.impl.repository.BaseMemoryRepository
import javax.inject.Inject

@ApplicationScope
class CartMemoryRepository @Inject constructor(
) : BaseMemoryRepository() {
    var cart: Cart? = null
}