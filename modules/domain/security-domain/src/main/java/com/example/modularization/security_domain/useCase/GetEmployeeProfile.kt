package com.example.modularization.security_domain.useCase

import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import javax.inject.Inject

class GetEmployeeProfile @Inject constructor(
    private val securityMemoryRepository: SecurityMemoryRepository
) : UseCase<Unit, EmployeeProfile> {
    override fun invoke(arg: Unit): EmployeeProfile {
        return securityMemoryRepository.employeeProfile!!
    }
}