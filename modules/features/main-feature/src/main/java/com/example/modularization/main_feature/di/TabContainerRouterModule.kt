package com.example.modularization.main_feature.di

import com.example.modularization.main_feature.router.MainRouterFragmentCreator
import com.example.modularization.main_feature.router.MainRouterFragmentFactory
import com.example.modularization.main_feature.router.TabContainerRouter
import com.example.modularization.main_feature.screens.tabs.TabContainerFragment
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.main_feature_api.TabNames
import com.example.modularization.ui_core.di.PerFeatureScope
import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TabContainerRouterModule {

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
        tabName = TabNames.CATALOGUE,
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
        tabName = TabNames.CART,
        mainRouterFragmentCreator = mainRouterFragmentCreator,
        fragmentFactory = fragmentFactory,
        navigatorHolder = Cicerone.create(cartTabRouter).getNavigatorHolder()
    )
}
