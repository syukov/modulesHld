package com.example.modularization.employee_auth_feature.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
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