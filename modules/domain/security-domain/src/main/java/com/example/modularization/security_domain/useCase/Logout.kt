package com.example.modularization.security_domain.useCase

import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.core_domain_api.models.domainEvents.DomainEvent
import com.example.modularization.core_domain_api.moduleApi.CoreDomainApi
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain.repository.SecurityRemoteRepository
import javax.inject.Inject

class Logout @Inject constructor(
    private val securityRemoteRepository: SecurityRemoteRepository,
    private val securityMemoryRepository: SecurityMemoryRepository,
    private val coreDomainApi: CoreDomainApi,
) : UseCase<Unit, Unit> {
    override fun invoke(arg: Unit) {
        securityRemoteRepository.logout()
        securityMemoryRepository.employeeProfile = null
        coreDomainApi.domainEventBus.pushEvent(DomainEvent.OnEmployeeLogout)
    }
}