package com.example.modularization.root_feature.di.nestedFeatureProviders

import com.example.modularization.main_feature.di.DaggerMainFeatureDi_FeatureComponent
import com.example.modularization.main_feature.di.MainFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
class MainFeatureProviderModule {
    @Provides
    fun provideComponent(
        rootRouter: RootRouter,
    ): MainFeatureDi.FeatureComponent {
        return DaggerMainFeatureDi_FeatureComponent.factory().create(
            object : MainFeatureDi.FactoryDependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        )
    }
}