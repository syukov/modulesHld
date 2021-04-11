package com.example.modularization.main_feature.di.nestedFeatureProviders

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.di.DaggerPdpFeatureDi_FeatureComponent
import com.example.modularization.pdp_feature.di.PdpFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class PdpFeatureProviderModule {
    @Provides
    @PerFeatureScope
    fun provideComponent(
        rootRouter: RootRouter,
        mainRouter: MainRouter,
    ): PdpFeatureDi.FeatureComponent {
        return DaggerPdpFeatureDi_FeatureComponent.factory().create(
            object : PdpFeatureDi.FactoryDependencies {
                override fun rootRouter(): RootRouter = rootRouter
                override fun mainRouter(): MainRouter = mainRouter
            }
        )
    }
}