package com.example.modularization.feature.employeeAuth.impl.di

import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.employeeAuth.impl.fragmentProvider.EmployeeAuthFeatureFragmentProvider
import com.example.modularization.feature.employeeAuth.impl.fragmentProvider.EmployeeAuthFeatureFragmentProviderDiModule
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component


interface EmployeeAuthFeatureDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            EmployeeAuthFeatureFragmentProviderDiModule::class
        ]
    )
    @PerFeatureScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }


    interface FactoryDependencies {
        val rootRouter: RootRouter
    }


    interface ApplicationScopeDependencies {
        val securityDomainApi: SecurityDomainApi
    }


    interface DiComponentInterface {
        val fragmentProvider: EmployeeAuthFeatureFragmentProvider
    }
}