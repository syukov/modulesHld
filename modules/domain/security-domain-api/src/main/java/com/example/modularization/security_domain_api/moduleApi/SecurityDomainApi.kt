package com.example.modularization.security_domain_api.moduleApi

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.domain_api_core.UseCase
import com.example.modularization.security_domain_api.models.EmployeeProfile

@DiDoc.Api
interface SecurityDomainApi {
    val loginEmployee: UseCase<String, EmployeeProfile>
    val getEmployeeProfile: UseCase<Unit, EmployeeProfile>
}