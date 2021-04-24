package com.example.modularization.catalogue_feature.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.catalogue_feature.fragmentProvider.CatalogueFeatureFragmentProvider
import com.example.modularization.catalogue_feature.fragmentProvider.CatalogueFeatureFragmentProviderDiModule
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import dagger.Component

@Doc.Structure
interface CatalogueFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CatalogueFeatureFragmentProviderDiModule::class,
        ]
    )
    @PerFeatureScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: CatalogueFeatureFragmentProvider
    }
}