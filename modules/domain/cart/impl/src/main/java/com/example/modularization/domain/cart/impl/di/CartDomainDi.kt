package com.example.modularization.domain.cart.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.domain.cart.impl.moduleApi.CartDomainApiDiModule
import com.example.modularization.domain.cart.impl.moduleApi.CartOnDomainEventDiModule
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import dagger.Component


interface CartDomainDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CartDomainApiDiModule::class,
            CartOnDomainEventDiModule::class,
        ]
    )
    @ApplicationScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }


    interface FactoryDependencies {
        /* no-op */
    }


    interface ApplicationScopeDependencies {
        val networkDomainApi: NetworkDomainApi
        val coreDomainApi: CoreDomainApi
    }


    interface DiComponentInterface {
        val cartDomainApi: CartDomainApi
        val onDomainEventListener: OnDomainEventListener
    }
}