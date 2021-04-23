package com.example.modularization.cart_domain.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface CartDomainReadApiDiModule {
    @ApplicationScope
    @Binds
    fun bindDomainReadApi(impl: CartDomainReadApiImpl): CartDomainReadApi
}