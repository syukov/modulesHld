package com.example.modularization.domain.security.impl.useCase

import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.domain.core.api.models.domainEvents.DomainEvent
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.security.impl.repository.SecurityMemoryRepository
import com.example.modularization.domain.security.impl.repository.SecurityRemoteRepository
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