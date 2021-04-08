package com.example.modularization.app_feature_impl.di.rootFeatureComponentProvider

import com.example.modularization.app_feature_impl.di.PerApplicationScope
import com.example.modularization.root_feature_api.RootFeatureContract
import dagger.Binds
import dagger.Module
import dagger.Provides


/**
 * В этом даггер-модуле мы прописывааем создание дочернего компонента с помощью фабрики и зависимостей.
 */
@Module
interface RootFeatureComponentProviderModule {
    companion object {
        @Provides
        @PerApplicationScope
        fun provideRootComponent(
            factory: RootFeatureContract.ComponentFactory,
            dependencies: RootFeatureContract.Dependencies
        ): RootFeatureContract.Component {
            return factory.create(dependencies)
        }
    }

    @Binds
    fun provideRootComponentDependencies(impl: RootFeatureDependenciesImpl): RootFeatureContract.Dependencies
}