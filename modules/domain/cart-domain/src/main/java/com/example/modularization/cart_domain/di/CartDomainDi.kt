package com.example.modularization.cart_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_domain.moduleApi.CartDomainApiDiModule
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Component

@DiDoc.Structure
interface CartDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CartDomainApiDiModule::class,
        ]
    )
    @ApplicationScope
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        /* no-op */
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        fun networkDomainApi(): NetworkDomainApi
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val cartDomainApi: CartDomainApi
    }
}