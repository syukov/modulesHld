package com.example.modularization.feature.employeeAuth.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @PerFeatureScope
    @Provides
    fun provideSecurityDomainApi(): SecurityDomainApi {
        return ApplicationScopeApiHolder.get(SecurityDomainApi::class.java)
    }
}