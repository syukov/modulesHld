package com.example.modularization.security_domain.moduleApi.useCase

import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain.repository.SecurityMemoryRepository
import com.example.modularization.security_domain.repository.SecurityRemoteRepository
import com.example.modularization.security_domain_api.models.EmployeeProfile
import javax.inject.Inject

class LoginEmployee @Inject constructor(
    private val securityRemoteRepository: SecurityRemoteRepository,
    private val securityMemoryRepository: SecurityMemoryRepository
) : UseCase<String, EmployeeProfile> {
    override fun invoke(arg: String): EmployeeProfile {
        val profile = securityRemoteRepository.loginEmployee(arg)
        securityMemoryRepository.employeeProfile = profile
        return profile
    }
}