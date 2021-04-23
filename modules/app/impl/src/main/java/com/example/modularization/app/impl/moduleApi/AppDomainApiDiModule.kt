package com.example.modularization.app.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface AppDomainApiDiModule {
    @Binds
    @ApplicationScope
    fun provideAppDomainApi(instance: AppDomainApiImpl): AppDomainApi
}