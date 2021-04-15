package com.example.modularization.security_domain.moduleApi.useCase

import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain.repository.SecurityRemoteRepository
import javax.inject.Inject

class Logout @Inject constructor(
    private val securityRemoteRepository: SecurityRemoteRepository,
    private val securityMemoryRepository: SecurityMemoryRepository,
    private val cartDomainApi: CartDomainApi,
) : UseCase<Unit, Unit> {
    override fun invoke(arg: Unit) {
        securityRemoteRepository.logout()
        securityMemoryRepository.employeeProfile = null
        cartDomainApi.clearCart.invoke(Unit)
    }
}