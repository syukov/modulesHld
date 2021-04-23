package com.example.modularization.security_domain_read_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain_read_api.models.EmployeeProfile

@Doc.Api
interface SecurityDomainReadApi {
    val getEmployeeProfile: UseCase<Unit, EmployeeProfile>
}