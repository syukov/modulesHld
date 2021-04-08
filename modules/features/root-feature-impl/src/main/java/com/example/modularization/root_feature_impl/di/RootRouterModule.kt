package com.example.modularization.root_feature_impl.di

import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.root_feature_impl.router.RootRouterImpl
import com.example.modularization.ui_core.di.PerFeatureScope
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides

@Module
interface RootRouterModule {

    companion object {
        private val rootRouterImpl = RootRouterImpl()

        @PerFeatureScope
        @Provides
        fun provideRootRouter(): RootRouter = rootRouterImpl

        @PerFeatureScope
        @Provides
        fun provideRootRouterNavigatorHolder(): NavigatorHolder {
            return Cicerone.create(rootRouterImpl).getNavigatorHolder()
        }
    }
}