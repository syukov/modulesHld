package com.example.modularization.security_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import com.example.modularization.security_domain.moduleApi.SecurityDomainApiDiModule
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Component

@DiDoc.Structure
interface SecurityDomainDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            SecurityDomainApiDiModule::class,
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
        val securityDomainApi: SecurityDomainApi
    }
}