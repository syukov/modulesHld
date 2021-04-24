package com.example.modularization.feature.cart.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
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