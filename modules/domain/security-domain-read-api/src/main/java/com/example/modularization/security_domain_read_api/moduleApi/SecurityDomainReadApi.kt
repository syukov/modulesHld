package com.example.modularization.security_domain_read_api.moduleApi

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.security_domain_read_api.models.EmployeeProfile

@Doc.Api
interface SecurityDomainReadApi {
    val getEmployeeProfile: UseCase<Unit, EmployeeProfile>
}