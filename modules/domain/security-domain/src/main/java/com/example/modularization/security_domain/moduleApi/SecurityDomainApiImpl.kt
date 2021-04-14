package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.security_domain.moduleApi.useCase.GetEmployeeProfile
import com.example.modularization.security_domain.moduleApi.useCase.LoginEmployee
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import javax.inject.Inject

@ApplicationScope
@DiDoc.Api.Implementation
class SecurityDomainApiImpl @Inject constructor(
    override val loginEmployee: LoginEmployee,
    override val getEmployeeProfile: GetEmployeeProfile
) : SecurityDomainApi