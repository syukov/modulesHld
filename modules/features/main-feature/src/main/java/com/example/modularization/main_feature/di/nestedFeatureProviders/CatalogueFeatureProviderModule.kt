package com.example.modularization.main_feature.di.nestedFeatureProviders

import com.example.modularization.catalogue_feature.di.CatalogueFeatureComponent
import com.example.modularization.catalogue_feature.di.DaggerCatalogueFeatureComponent
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class CatalogueFeatureProviderModule {
    @Provides
    @PerFeatureScope
    fun provideComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): CatalogueFeatureComponent {
        return DaggerCatalogueFeatureComponent.factory().create(
            object : CatalogueFeatureComponent.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
                override fun mainRouter(): MainRouter = mainRouter
            }
        )
    }
}