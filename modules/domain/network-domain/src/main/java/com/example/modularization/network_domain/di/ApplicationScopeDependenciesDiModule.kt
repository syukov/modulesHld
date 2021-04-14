package com.example.modularization.network_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import dagger.Module
import dagger.Provides

@Module
@DiDoc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    @ApplicationScope
    fun appDomainApi(): AppDomainApi {
        return ApplicationScopeApiHolder.get(AppDomainApi::class.java)
    }
}