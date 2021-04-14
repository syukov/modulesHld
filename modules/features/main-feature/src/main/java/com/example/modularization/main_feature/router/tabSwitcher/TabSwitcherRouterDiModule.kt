package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.core_feature.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class TabSwitcherRouterDiModule {

    @PerFeatureScope
    @Provides
    fun provideTabSwitcherRouter(): TabSwitcherRouter = TabSwitcherRouter()
}
