package com.example.modularization.main_feature.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_feature.di.CartFeatureDi
import com.example.modularization.cart_feature.di.DaggerCartFeatureDi_DiComponent
import com.example.modularization.catalogue_feature.di.CatalogueFeatureDi
import com.example.modularization.catalogue_feature.di.DaggerCatalogueFeatureDi_DiComponent
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.di.DaggerPdpFeatureDi_DiComponent
import com.example.modularization.pdp_feature.di.PdpFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
@Doc.NestedScopeComponentsDiModule
class NestedScopeComponentsDiModule {
    @Provides
    @PerFeatureScope
    fun providePdpFeatureDiComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): PdpFeatureDi.DiComponent {
        return DaggerPdpFeatureDi_DiComponent.factory().create(
            object : PdpFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
                override val mainRouter: MainRouter = mainRouter
            }
        )
    }

    @Provides
    @PerFeatureScope
    fun provideCatalogueFeatureDiComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): CatalogueFeatureDi.DiComponent {
        return DaggerCatalogueFeatureDi_DiComponent.factory().create(
            object : CatalogueFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
                override val mainRouter: MainRouter = mainRouter
            }
        )
    }

    @Provides
    @PerFeatureScope
    fun provideCartFeatureDiComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): CartFeatureDi.DiComponent {
        return DaggerCartFeatureDi_DiComponent.factory().create(
            object : CartFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
                override val mainRouter: MainRouter = mainRouter
            }
        )
    }
}