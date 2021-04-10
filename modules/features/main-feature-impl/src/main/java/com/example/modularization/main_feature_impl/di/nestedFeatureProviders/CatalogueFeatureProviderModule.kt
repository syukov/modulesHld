package com.example.modularization.main_feature_impl.di.nestedFeatureProviders

import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class CatalogueFeatureProviderModule {
    companion object {
        @Provides
        @PerFeatureScope
        fun provideFeatureComponentApi(
            factory: CatalogueFeatureLauncher.ComponentFactoryApi,
            dependencies: CatalogueFeatureLauncher.Dependencies
        ): CatalogueFeatureLauncher.ComponentApi {
            return factory.create(dependencies)
        }

        @Provides
        fun provideFeatureComponentDependencies(
            rootRouter: RootRouter,
            mainRouter: MainRouter
        ): CatalogueFeatureLauncher.Dependencies {
            return object : CatalogueFeatureLauncher.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
                override fun mainRouter(): MainRouter = mainRouter
            }
        }
    }
}