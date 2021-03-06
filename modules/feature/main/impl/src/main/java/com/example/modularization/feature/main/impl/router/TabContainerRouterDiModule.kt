package com.example.modularization.feature.main.impl.router

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.main.api.TabNames
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabContainerRouter
import com.example.modularization.feature.main.impl.screens.tabs.TabContainerFragment
import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TabContainerRouterDiModule {

    // CATALOGUE

    private val catalogueTabRouter: TabContainerRouter = TabContainerRouter(MainRouter.Tab.Catalogue)

    @PerFeatureScope
    @Provides
    @Named(TabNames.CATALOGUE)
    fun provideCatalogueTabContainerRouter(): TabContainerRouter = catalogueTabRouter

    @PerFeatureScope
    @Provides
    @Named(TabNames.CATALOGUE)
    fun provideCatalogueTabContainerFragment(
        mainRouterFragmentCreator: MainRouterFragmentCreator,
        fragmentFactory: MainRouterFragmentFactory,
    ): TabContainerFragment = TabContainerFragment(
        tab = MainRouter.Tab.Catalogue,
        mainRouterFragmentCreator = mainRouterFragmentCreator,
        fragmentFactory = fragmentFactory,
        navigatorHolder = Cicerone.create(catalogueTabRouter).getNavigatorHolder()
    )

    // CART

    private val cartTabRouter: TabContainerRouter = TabContainerRouter(MainRouter.Tab.Cart)

    @PerFeatureScope
    @Provides
    @Named(TabNames.CART)
    fun provideCartTabContainerRouter(): TabContainerRouter = cartTabRouter

    @PerFeatureScope
    @Provides
    @Named(TabNames.CART)
    fun provideCartTabContainerFragment(
        mainRouterFragmentCreator: MainRouterFragmentCreator,
        fragmentFactory: MainRouterFragmentFactory,
    ): TabContainerFragment = TabContainerFragment(
        tab = MainRouter.Tab.Cart,
        mainRouterFragmentCreator = mainRouterFragmentCreator,
        fragmentFactory = fragmentFactory,
        navigatorHolder = Cicerone.create(cartTabRouter).getNavigatorHolder()
    )
}
