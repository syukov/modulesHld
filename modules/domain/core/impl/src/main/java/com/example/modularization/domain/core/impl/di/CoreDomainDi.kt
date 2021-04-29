package com.example.modularization.domain.core.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.core.impl.domainEvents.DomainEventBusDiModule
import com.example.modularization.domain.core.impl.moduleApi.CoreDomainApiDiModule
import dagger.Component


interface CoreDomainDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            CoreDomainApiDiModule::class,
            DomainEventBusDiModule::class,
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
        /* no-op */
    }


    interface DiComponentInterface {
        val coreDomainApi: CoreDomainApi
    }
}