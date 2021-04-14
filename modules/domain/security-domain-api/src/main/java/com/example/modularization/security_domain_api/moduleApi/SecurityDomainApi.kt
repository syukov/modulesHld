package com.example.modularization.security_domain_api.moduleApi

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain_api.models.EmployeeProfile

@DiDoc.Api
interface SecurityDomainApi {
    val loginEmployee: UseCase<String, EmployeeProfile>
    val getEmployeeProfile: UseCase<Unit, EmployeeProfile>
}