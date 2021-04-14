package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class TabSwitcherRouterDiModule {

    @PerFeatureScope
    @Provides
    fun provideTabSwitcherRouter(): TabSwitcherRouter = TabSwitcherRouter()
}
