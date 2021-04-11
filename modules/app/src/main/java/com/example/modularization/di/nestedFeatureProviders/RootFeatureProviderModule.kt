package com.example.modularization.di.nestedFeatureProviders

import com.example.modularization.di.PerApplicationScope
import com.example.modularization.root_feature.di.DaggerRootFeatureDi_FeatureComponent
import com.example.modularization.root_feature.di.RootFeatureDi
import dagger.Module
import dagger.Provides

@Module
class RootFeatureProviderModule {
    @Provides
    @PerApplicationScope
    fun provideComponent(
    ): RootFeatureDi.FeatureComponent {
        return DaggerRootFeatureDi_FeatureComponent.factory().create(
            object : RootFeatureDi.FactoryDependencies {}
        )
    }
}