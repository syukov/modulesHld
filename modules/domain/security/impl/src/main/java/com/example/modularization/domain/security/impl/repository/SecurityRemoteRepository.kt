package com.example.modularization.domain.security.impl.repository

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.impl.repository.BaseRemoteRepository
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import com.example.modularization.domain.security.api.models.EmployeeProfile
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