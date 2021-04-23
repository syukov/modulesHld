package com.example.modularization.domain.cart.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.domain.cart.impl.moduleApi.CartDomainApiDiModule
import com.example.modularization.domain.cart.impl.moduleApi.CartOnDomainEventDiModule
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
        val onDomainEventListener: OnDomainEventListener
    }
}