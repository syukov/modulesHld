package com.example.modularization.main_feature_impl.di

import com.example.modularization.main_feature_impl.router.MainRouterImpl
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides

@Module
interface MainRouterModule {

    companion object {
        private val mainRouterImpl = MainRouterImpl()

        @PerFeatureScope
        @Provides
        fun provideMainRouter(): MainRouter = mainRouterImpl

        @PerFeatureScope
        @Provides
        fun provideMainRouterNavigatorHolder(): NavigatorHolder {
            return Cicerone.create(mainRouterImpl).getNavigatorHolder()
        }
    }
}