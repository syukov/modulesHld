package com.example.modularization.domain.security.impl.useCase

import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.domain.security.api.models.EmployeeProfile
import com.example.modularization.domain.security.impl.repository.SecurityMemoryRepository
import javax.inject.Inject

class GetEmployeeProfile @Inject constructor(
    private val securityMemoryRepository: SecurityMemoryRepository
) : UseCase<Unit, EmployeeProfile> {
    override fun invoke(arg: Unit): EmployeeProfile {
        return securityMemoryRepository.employeeProfile!!
    }
}