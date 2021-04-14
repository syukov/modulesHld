package com.example.modularization.catalogue_feature.di

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.catalogue_feature.fragmentProvider.CatalogueFeatureFragmentProvider
import com.example.modularization.catalogue_feature.fragmentProvider.CatalogueFeatureFragmentProviderDiModule
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@DiDoc.Structure
interface CatalogueFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CatalogueFeatureFragmentProviderDiModule::class,
        ]
    )
    @PerFeatureScope
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: CatalogueFeatureFragmentProvider
    }
}