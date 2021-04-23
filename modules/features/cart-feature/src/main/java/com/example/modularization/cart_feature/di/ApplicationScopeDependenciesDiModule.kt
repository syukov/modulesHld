package com.example.modularization.cart_feature.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    fun provideAppDomainApi(): AppDomainApi = ApplicationScopeApiHolder.get(AppDomainApi::class.java)

    @Provides
    fun provideCartDomainApi(): CartDomainApi = ApplicationScopeApiHolder.get(CartDomainApi::class.java)
}