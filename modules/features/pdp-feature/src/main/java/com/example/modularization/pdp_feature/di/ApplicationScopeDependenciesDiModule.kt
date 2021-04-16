package com.example.modularization.pdp_feature.di

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import dagger.Module
import dagger.Provides

@Module
@Doc.ApplicationScopeDependenciesDiModule
class ApplicationScopeDependenciesDiModule {
    @Provides
    fun appDomainApi(): AppDomainApi = ApplicationScopeApiHolder.get(AppDomainApi::class.java)

    @Provides
    fun cartDomainApi(): CartDomainApi = ApplicationScopeApiHolder.get(CartDomainApi::class.java)
}