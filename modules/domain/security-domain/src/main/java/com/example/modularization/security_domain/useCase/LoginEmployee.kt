package com.example.modularization.security_domain.useCase

import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain.repository.SecurityRemoteRepository
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import javax.inject.Inject

class LoginEmployee @Inject constructor(
    private val securityRemoteRepository: SecurityRemoteRepository,
    private val securityMemoryRepository: SecurityMemoryRepository
) : UseCase<String, EmployeeProfile> {
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun invoke(login: String): EmployeeProfile {
        val profile = securityRemoteRepository.loginEmployee(login)
        securityMemoryRepository.employeeProfile = profile
        return profile
    }
}