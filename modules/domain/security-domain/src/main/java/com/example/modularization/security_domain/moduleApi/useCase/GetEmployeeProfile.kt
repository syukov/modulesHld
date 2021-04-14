package com.example.modularization.security_domain.moduleApi.useCase

import com.example.modularization.domain_api_core.UseCase
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain_api.models.EmployeeProfile
import javax.inject.Inject

class GetEmployeeProfile @Inject constructor(
    private val securityMemoryRepository: SecurityMemoryRepository
) : UseCase<Unit, EmployeeProfile> {
    override fun invoke(arg: Unit): EmployeeProfile {
        return securityMemoryRepository.employeeProfile!!
    }
}