package com.example.modularization.feature.employeeAuth.impl.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.employeeAuth.impl.fragmentProvider.EmployeeAuthFeatureFragmentProvider
import com.example.modularization.feature.employeeAuth.impl.fragmentProvider.EmployeeAuthFeatureFragmentProviderDiModule
import com.example.modularization.root_feature_api.RootRouter
import dagger.Component


@Doc.Structure
interface EmployeeAuthFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            EmployeeAuthFeatureFragmentProviderDiModule::class
        ]
    )
    @PerFeatureScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val securityDomainApi: SecurityDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: EmployeeAuthFeatureFragmentProvider
    }
}