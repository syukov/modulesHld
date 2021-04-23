package com.example.modularization.security_domain_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import com.example.modularization.security_domain_read_api.moduleApi.SecurityDomainReadApi

@Doc.Api
interface SecurityDomainApi : SecurityDomainReadApi {
    // read-only use cases:
    override val getEmployeeProfile: UseCase<Unit, EmployeeProfile>

    // write use cases:
    val loginEmployee: UseCase<String, EmployeeProfile>
    val logout: UseCase<Unit, Unit>
}