package com.example.modularization.main_feature.di

import com.example.modularization.main_feature.router.TabSwitcherRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class TabSwitcherRouterModule {

    @PerFeatureScope
    @Provides
    fun provideTabSwitcherRouter(): TabSwitcherRouter = TabSwitcherRouter()
}
