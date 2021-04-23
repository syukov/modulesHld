package com.example.modularization.domain.security.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.domain.security.impl.moduleApi.SecurityDomainApiDiModule
import com.example.modularization.domain.security.impl.moduleApi.SecurityOnDomainEventListenerDiModule
import dagger.Component

@Doc.Structure
interface SecurityDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            SecurityDomainApiDiModule::class,
            SecurityOnDomainEventListenerDiModule::class,
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
        val coreDomainApi: CoreDomainApi
        val networkDomainApi: NetworkDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val securityDomainApi: SecurityDomainApi
        val onDomainEventListener: OnDomainEventListener
    }
}