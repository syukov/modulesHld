package com.example.modularization.root_feature_impl.di.nestedFeatureProviders

import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class MainFeatureProviderModule {
    companion object {
        @Provides
        @PerFeatureScope
        fun provideMainFeatureComponentApi(
            factory: MainFeatureLauncher.ComponentFactoryApi,
            dependencies: MainFeatureLauncher.Dependencies
        ): MainFeatureLauncher.ComponentApi {
            return factory.create(dependencies)
        }

        @Provides
        fun provideMainFeatureComponentDependencies(
            rootRouter: RootRouter
        ): MainFeatureLauncher.Dependencies {
            return object : MainFeatureLauncher.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        }
    }
}