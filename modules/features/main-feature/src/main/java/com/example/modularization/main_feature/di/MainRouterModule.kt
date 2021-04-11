package com.example.modularization.main_feature.di

import com.example.modularization.cart_feature.screens.cart.CartFragment
import com.example.modularization.catalogue_feature.screens.catalogue.CatalogueFragment
import com.example.modularization.catalogue_feature.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.main_feature.router.MainRouterImpl
import com.example.modularization.main_feature.router.TabContainerRouter
import com.example.modularization.main_feature.router.TabSwitcherRouter
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.main_feature_api.TabNames
import com.example.modularization.pdp_feature.screens.pdp.PdpFragment
import com.example.modularization.ui_core.di.PerFeatureScope
import com.example.modularization.ui_core.utils.checkWhenBranches
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        TabContainerRouterModule::class,
        TabSwitcherRouterModule::class,
    ]
)
class MainRouterModule {
    /**
     * Хук с рефлексией для того что бы компилятор нам подсказал если мы создали Screen и забыли указать ему имя фрагмента
     */
    private val fragmentsMap: Map<String, MainRouter.Screen> = mutableMapOf<String, MainRouter.Screen>().apply {
        MainRouter.Screen::class.sealedSubclasses
            .mapNotNull { it.objectInstance }
            .forEach {
                when (it) {
                    MainRouter.Screen.CatalogueFeature.Catalogue -> put(CatalogueFragment::class.java.name, it)
                    MainRouter.Screen.CatalogueFeature.SubCatalogue -> put(SubCatalogueFragment::class.java.name, it)
                    MainRouter.Screen.PdpFeature.Pdp -> put(PdpFragment::class.java.name, it)
                    MainRouter.Screen.CartFeature.Cart -> put(CartFragment::class.java.name, it)
                }.checkWhenBranches
            }
    }

    @Provides
    fun provideScreenResolver() = object : MainRouter.ScreensResolver {
        override fun getScreenByFragmentName(fragmentName: String): MainRouter.Screen {
            return fragmentsMap[fragmentName]
                ?: throw UnsupportedOperationException("$fragmentName should be registered in ${MainRouterModule::class.simpleName} to be opened in MainRouter")
        }
    }


    @PerFeatureScope
    @Provides
    fun provideMainRouter(
        tabSwitcherRouter: TabSwitcherRouter,
        @Named(TabNames.CATALOGUE) catalogueTabRouter: TabContainerRouter,
        @Named(TabNames.CART) cartTabRouter: TabContainerRouter,
    ): MainRouter = MainRouterImpl(tabSwitcherRouter, catalogueTabRouter, cartTabRouter)
}
