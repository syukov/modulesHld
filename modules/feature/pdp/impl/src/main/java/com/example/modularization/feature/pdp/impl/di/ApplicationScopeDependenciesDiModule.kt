package com.example.modularization.feature.pdp.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationScopeDependenciesDiModule {

    @Provides
    fun appDomainApi(): AppDomainApi = ApplicationScopeServiceLocator.get(AppDomainApi::class.java)

    @Provides
    fun cartDomainApi(): CartDomainApi = ApplicationScopeServiceLocator.get(CartDomainApi::class.java)
}