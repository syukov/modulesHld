package com.example.modularization.domain.security.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.UseCase
import com.example.modularization.domain.security.api.models.EmployeeProfile
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.domain.security.impl.useCase.GetEmployeeProfile
import com.example.modularization.domain.security.impl.useCase.LoginEmployee
import com.example.modularization.domain.security.impl.useCase.Logout
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