package com.example.modularization.root_feature_impl.di.nestedFeatureProviders

import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.main_feature_impl.di.MainFeatureComponent
import com.example.modularization.root_feature_data.RootRouter
import dagger.Module
import dagger.Provides

@Module
class MainFeatureProviderModule {
    @Provides
    fun provideComponent(
        rootRouter: RootRouter,
    ): MainFeatureComponent {
        return DaggerMainFeatureComponent.factory().create(
            object : MainFeatureComponent.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        )
    }
}