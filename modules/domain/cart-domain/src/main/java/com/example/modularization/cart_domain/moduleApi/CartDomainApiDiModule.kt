package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import dagger.Binds
import dagger.Module

@Module
@DiDoc.Api.DiModule
interface CartDomainApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: CartDomainApiImpl): CartDomainApi
}