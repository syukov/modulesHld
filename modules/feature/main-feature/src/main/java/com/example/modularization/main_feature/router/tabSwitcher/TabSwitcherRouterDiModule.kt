package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class TabSwitcherRouterDiModule {

    @PerFeatureScope
    @Provides
    fun provideTabSwitcherRouter(): TabSwitcherRouter = TabSwitcherRouter()
}
