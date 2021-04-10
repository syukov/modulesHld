package com.example.modularization.main_feature_impl.di.nestedFeatureProviders

import com.example.modularization.catalogue_feature_impl.di.CatalogueFeatureComponent
import com.example.modularization.catalogue_feature_impl.di.DaggerCatalogueFeatureComponent
import com.example.modularization.main_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter
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