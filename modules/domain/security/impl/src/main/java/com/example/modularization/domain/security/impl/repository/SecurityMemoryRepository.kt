package com.example.modularization.domain.security.impl.repository

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.impl.repository.BaseMemoryRepository
import com.example.modularization.domain.security.api.models.EmployeeProfile
import javax.inject.Inject

@ApplicationScope
class SecurityMemoryRepository @Inject constructor(
) : BaseMemoryRepository() {
    var employeeProfile: EmployeeProfile? = null
}