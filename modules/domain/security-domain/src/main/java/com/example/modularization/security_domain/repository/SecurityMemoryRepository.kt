package com.example.modularization.security_domain.repository

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.domain_impl_core.repository.BaseMemoryRepository
import com.example.modularization.security_domain_api.models.EmployeeProfile
import javax.inject.Inject

@ApplicationScope
class SecurityMemoryRepository @Inject constructor(
) : BaseMemoryRepository() {
    var employeeProfile: EmployeeProfile? = null
}