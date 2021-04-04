package com.example.modularization.app_feature_impl.di

import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.app_feature_impl.appRouter.AppRouterImpl
import com.example.modularization.app_feature_impl.di.screenToNameMapper.AppRouterScreenToNameMapper
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    companion object {
        private val appRouterImpl = AppRouterImpl()

        @PerApplicationScope
        @Provides
        fun provideAppRouter(): AppRouter = appRouterImpl

        @PerApplicationScope
        @Provides
        fun provideAppRouterNavigatorHolder(): NavigatorHolder {
            return Cicerone.create(appRouterImpl).getNavigatorHolder()
        }
    }


    @PerApplicationScope
    @Binds
    fun bindAppRouterScreenToNameMapper(instance: AppRouterScreenToNameMapper): AppRouter.ScreenToNameMapper
}