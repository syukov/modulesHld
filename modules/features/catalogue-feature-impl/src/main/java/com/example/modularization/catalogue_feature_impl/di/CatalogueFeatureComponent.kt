package com.example.modularization.catalogue_feature_impl.di

import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [CatalogueFeatureLauncher.Dependencies::class],
    modules = [
        CatalogueFeatureModule::class
    ]
)
@PerFeatureScope
interface CatalogueFeatureComponent : CatalogueFeatureLauncher.ComponentApi {

    @Component.Factory
    interface ComponentFactory : CatalogueFeatureLauncher.ComponentFactoryApi {
        override fun create(dependencies: CatalogueFeatureLauncher.Dependencies): CatalogueFeatureComponent
    }
}