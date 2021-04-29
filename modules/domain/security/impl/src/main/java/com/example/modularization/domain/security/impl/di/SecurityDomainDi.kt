package com.example.modularization.domain.security.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.api.models.domainEvents.OnDomainEventListener
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.domain.security.impl.moduleApi.SecurityDomainApiDiModule
import com.example.modularization.domain.security.impl.moduleApi.SecurityOnDomainEventListenerDiModule
import dagger.Component


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
        val coreDomainApi: CoreDomainApi
        val networkDomainApi: NetworkDomainApi
    }


    interface DiComponentInterface {
        val securityDomainApi: SecurityDomainApi
        val onDomainEventListener: OnDomainEventListener
    }
}