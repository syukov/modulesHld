package com.example.modularization.domain.network.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import com.example.modularization.domain.network.impl.moduleApi.NetworkDomainApiDiModule
import dagger.Component


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
        val appDomainApi: AppDomainApi
    }


    interface DiComponentInterface {
        val networkDomainApi: NetworkDomainApi
    }
}