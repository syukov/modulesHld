package com.example.modularization.cart_domain.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain.moduleApi.CartDomainApiDiModule
import com.example.modularization.cart_domain.moduleApi.CartDomainReadApiDiModule
import com.example.modularization.cart_domain.moduleApi.CartOnDomainEventDiModule
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.cart_domain_read_api.moduleApi.CartDomainReadApi
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Component

@Doc.Structure
interface CartDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CartDomainApiDiModule::class,
            CartDomainReadApiDiModule::class,
            CartOnDomainEventDiModule::class,
        ]
    )

    @ApplicationScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        /* no-op */
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val networkDomainApi: NetworkDomainApi
        val coreDomainApi: CoreDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val cartDomainApi: CartDomainApi
        val cartDomainReadApi: CartDomainReadApi
        val onDomainEventListener: OnDomainEventListener
    }
}