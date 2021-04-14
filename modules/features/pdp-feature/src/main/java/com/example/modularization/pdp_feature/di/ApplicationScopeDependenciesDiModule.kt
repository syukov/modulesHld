package com.example.modularization.pdp_feature.di

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import dagger.Module
import dagger.Provides

@Module
@DiDoc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    fun networkDomainApi(): AppDomainApi {
        return ApplicationScopeApiHolder.get(AppDomainApi::class.java)
    }
}