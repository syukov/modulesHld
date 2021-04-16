package com.example.modularization.security_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.security_domain.useCase.GetEmployeeProfile
import com.example.modularization.security_domain.useCase.LoginEmployee
import com.example.modularization.security_domain.useCase.Logout
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
@Doc.Api.Implementation
class SecurityDomainApiImpl @Inject constructor(
    private val loginEmployeeProvider: Provider<LoginEmployee>,
    private val logoutProvider: Provider<Logout>,
    private val getEmployeeProfileProvider: Provider<GetEmployeeProfile>,
) : SecurityDomainApi {

    override val loginEmployee: UseCase<String, EmployeeProfile> get() = loginEmployeeProvider.get()
    override val logout: UseCase<Unit, Unit> get() = logoutProvider.get()
    override val getEmployeeProfile: UseCase<Unit, EmployeeProfile> get() = getEmployeeProfileProvider.get()
}