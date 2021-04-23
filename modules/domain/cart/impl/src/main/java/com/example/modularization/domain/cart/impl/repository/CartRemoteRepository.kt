package com.example.modularization.domain.cart.impl.repository

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.impl.repository.BaseRemoteRepository
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import javax.inject.Inject


@ApplicationScope
class CartRemoteRepository @Inject constructor(
    private val networkDomainApi: NetworkDomainApi
) : BaseRemoteRepository() {
    fun addProduct(sku: Sku) {
        return networkDomainApi.retrofit.stub { }
    }
}