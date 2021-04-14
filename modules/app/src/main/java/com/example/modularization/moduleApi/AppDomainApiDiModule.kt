package com.example.modularization.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import dagger.Binds
import dagger.Module

@Module
@DiDoc.Api.DiModule
interface AppDomainApiDiModule {
    @Binds
    @ApplicationScope
    fun provideAppDomainApi(instance: AppDomainApiImpl): AppDomainApi
}