package com.example.modularization.network_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.network_domain.moduleApi.NetworkDomainApiDiModule
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Component

@DiDoc.Structure
interface NetworkDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            NetworkDomainApiDiModule::class,
            NetworkDomainDiModule::class,
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
        val appDomainApi: AppDomainApi
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val networkDomainApi: NetworkDomainApi
    }
}