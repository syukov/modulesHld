package com.example.modularization.feature.main.impl.router

import com.example.modularization.core_feature.utils.checkWhenBranches
import com.example.modularization.feature.cart.impl.screens.cart.CartFragment
import com.example.modularization.feature.catalogue.impl.screens.catalogue.CatalogueFragment
import com.example.modularization.feature.catalogue.impl.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.main.api.TabNames
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabContainerRouter
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabSwitcherRouter
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabSwitcherRouterDiModule
import com.example.modularization.feature.pdp.impl.screens.pdp.PdpFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        TabContainerRouterDiModule::class,
        TabSwitcherRouterDiModule::class,
    ]
)
class MainRouterDiModule {
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
                ?: throw UnsupportedOperationException("$fragmentName should be registered in ${MainRouterDiModule::class.simpleName} to be opened in MainRouter")
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
