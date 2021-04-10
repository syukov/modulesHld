package com.example.modularization.di.nestedFeatureProviders

import com.example.modularization.di.PerApplicationScope
import com.example.modularization.root_feature_impl.di.DaggerRootFeatureComponent
import com.example.modularization.root_feature_impl.di.RootFeatureComponent
import dagger.Module
import dagger.Provides

@Module
class RootFeatureProviderModule {
    @Provides
    @PerApplicationScope
    fun provideComponent(
    ): RootFeatureComponent {
        return DaggerRootFeatureComponent.factory().create(
            object : RootFeatureComponent.Dependencies {}
        )
    }
}