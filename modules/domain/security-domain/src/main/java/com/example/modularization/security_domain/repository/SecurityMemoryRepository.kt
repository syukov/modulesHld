package com.example.modularization.security_domain.repository

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.core_domain.repository.BaseMemoryRepository
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import javax.inject.Inject

@ApplicationScope
class SecurityMemoryRepository @Inject constructor(
) : BaseMemoryRepository() {
    var employeeProfile: EmployeeProfile? = null
}