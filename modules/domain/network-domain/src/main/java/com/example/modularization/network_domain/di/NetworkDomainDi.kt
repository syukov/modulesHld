package com.example.modularization.network_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.network_domain.moduleApi.NetworkDomainApiDiModule
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import dagger.Component

@Doc.Structure
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
        val appDomainApi: AppDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val networkDomainApi: NetworkDomainApi
    }
}