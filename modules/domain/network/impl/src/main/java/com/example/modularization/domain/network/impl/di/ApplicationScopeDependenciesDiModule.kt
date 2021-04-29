package com.example.modularization.domain.network.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.app.api.moduleApi.AppDomainApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @Provides
    @ApplicationScope
    fun appDomainApi(): AppDomainApi {
        return ApplicationScopeServiceLocator.get(AppDomainApi::class.java)
    }
}