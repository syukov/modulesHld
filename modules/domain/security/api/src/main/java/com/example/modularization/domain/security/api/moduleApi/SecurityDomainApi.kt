package com.example.modularization.domain.security.api.moduleApi

import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.domain.security.api.models.EmployeeProfile


interface SecurityDomainApi {
    val getEmployeeProfile: UseCase<Unit, EmployeeProfile>
    val loginEmployee: UseCase<String, EmployeeProfile>
    val logout: UseCase<Unit, Unit>
}