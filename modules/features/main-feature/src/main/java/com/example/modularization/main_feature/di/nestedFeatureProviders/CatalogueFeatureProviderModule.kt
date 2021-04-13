package com.example.modularization.main_feature.di.nestedFeatureProviders

import com.example.modularization.catalogue_feature.di.CatalogueFeatureDi
import com.example.modularization.catalogue_feature.di.DaggerCatalogueFeatureDi_FeatureComponent
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
    ): CatalogueFeatureDi.FeatureComponent {
        return DaggerCatalogueFeatureDi_FeatureComponent.factory().create(
            object : CatalogueFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
                override val mainRouter: MainRouter = mainRouter
            }
        )
    }
}