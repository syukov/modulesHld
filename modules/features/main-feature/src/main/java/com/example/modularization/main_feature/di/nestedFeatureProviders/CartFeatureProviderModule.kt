package com.example.modularization.main_feature.di.nestedFeatureProviders

import com.example.modularization.cart_feature.di.CartFeatureDi
import com.example.modularization.cart_feature.di.DaggerCartFeatureDi_FeatureComponent
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class CartFeatureProviderModule {
    @Provides
    @PerFeatureScope
    fun provideComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): CartFeatureDi.FeatureComponent {
        return DaggerCartFeatureDi_FeatureComponent.factory().create(
            object : CartFeatureDi.FactoryDependencies {
                override fun rootRouter(): RootRouter = rootRouter
                override fun mainRouter(): MainRouter = mainRouter
            }
        )
    }
}