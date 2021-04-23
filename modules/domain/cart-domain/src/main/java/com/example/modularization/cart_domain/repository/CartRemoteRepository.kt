package com.example.modularization.cart_domain.repository

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.core_domain.repository.BaseRemoteRepository
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import javax.inject.Inject


@ApplicationScope
class CartRemoteRepository @Inject constructor(
    private val networkDomainApi: NetworkDomainApi
) : BaseRemoteRepository() {
    fun addProduct(sku: Sku) {
        return networkDomainApi.retrofit.stub { }
    }
}