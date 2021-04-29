package com.example.modularization.domain.cart.impl.moduleApi

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import dagger.Binds
import dagger.Module

@Module
interface CartDomainApiDiModule {

    @ApplicationScope
    @Binds
    fun bindDomainApi(impl: CartDomainApiImpl): CartDomainApi
}