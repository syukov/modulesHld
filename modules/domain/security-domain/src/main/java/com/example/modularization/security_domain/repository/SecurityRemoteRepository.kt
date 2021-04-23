package com.example.modularization.security_domain.repository

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.impl.repository.BaseRemoteRepository
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import com.example.modularization.security_domain_read_api.models.EmployeeProfile
import javax.inject.Inject


@ApplicationScope
class SecurityRemoteRepository @Inject constructor(
    private val networkDomainApi: NetworkDomainApi
) : BaseRemoteRepository() {
    fun loginEmployee(login: String): EmployeeProfile {
        return networkDomainApi.retrofit.stub { EmployeeProfile(login, "name", "shop") }
    }

    fun logout() {
        networkDomainApi.retrofit.stub { }
    }
}