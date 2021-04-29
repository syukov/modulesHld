package com.example.modularization.feature.catalogue.impl.di

import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.feature.catalogue.impl.fragmentProvider.CatalogueFeatureFragmentProvider
import com.example.modularization.feature.catalogue.impl.fragmentProvider.CatalogueFeatureFragmentProviderDiModule
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component


interface CatalogueFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CatalogueFeatureFragmentProviderDiModule::class,
        ]
    )
    @PerFeatureScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }


    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }


    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }


    interface DiComponentInterface {
        val fragmentProvider: CatalogueFeatureFragmentProvider
    }
}