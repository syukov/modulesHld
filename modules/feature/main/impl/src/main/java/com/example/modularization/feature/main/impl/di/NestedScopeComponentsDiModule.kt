package com.example.modularization.feature.main.impl.di

import com.example.modularization.feature.cart.impl.di.CartFeatureDi
import com.example.modularization.feature.cart.impl.di.DaggerCartFeatureDi_DiComponent
import com.example.modularization.feature.catalogue.impl.di.CatalogueFeatureDi
import com.example.modularization.feature.catalogue.impl.di.DaggerCatalogueFeatureDi_DiComponent
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.pdp.impl.di.DaggerPdpFeatureDi_DiComponent
import com.example.modularization.feature.pdp.impl.di.PdpFeatureDi
import com.example.modularization.feature.root.api.RootRouter
import dagger.Module
import dagger.Provides

@Module
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