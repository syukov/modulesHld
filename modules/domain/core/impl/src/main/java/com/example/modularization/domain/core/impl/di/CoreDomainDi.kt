package com.example.modularization.domain.core.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.core.impl.domainEvents.DomainEventBusDiModule
import com.example.modularization.domain.core.impl.moduleApi.CoreDomainApiDiModule
import dagger.Component

@Doc.Structure
interface CoreDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            CoreDomainApiDiModule::class,
            DomainEventBusDiModule::class,
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
        /* no-op */
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val coreDomainApi: CoreDomainApi
    }
}