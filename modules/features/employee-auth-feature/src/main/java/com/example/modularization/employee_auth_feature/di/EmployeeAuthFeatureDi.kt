package com.example.modularization.employee_auth_feature.di

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.employee_auth_feature.fragmentProvider.EmployeeAuthFeatureFragmentProvider
import com.example.modularization.employee_auth_feature.fragmentProvider.EmployeeAuthFeatureFragmentProviderDiModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import dagger.Component


@DiDoc.Structure
interface EmployeeAuthFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            EmployeeAuthFeatureFragmentProviderDiModule::class
        ]
    )
    @PerFeatureScope
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val securityDomainApi: SecurityDomainApi
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: EmployeeAuthFeatureFragmentProvider
    }
}