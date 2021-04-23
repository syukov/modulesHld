package com.example.modularization.domain.security.impl.useCase

import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.domain.security.api.models.EmployeeProfile
import com.example.modularization.domain.security.impl.repository.SecurityMemoryRepository
import com.example.modularization.domain.security.impl.repository.SecurityRemoteRepository
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