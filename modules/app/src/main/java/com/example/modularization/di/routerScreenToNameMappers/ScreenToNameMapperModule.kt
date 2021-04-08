package com.example.modularization.di.routerScreenToNameMappers

import com.example.modularization.root_feature_data.RootRouter
import dagger.Binds
import dagger.Module

@Module
interface ScreenToNameMapperModule {

    @Binds
    fun provideRootRouterScreenToNameMapper(impl: RootRouterScreenToNameMapper): RootRouter.ScreenToNameMapper
}