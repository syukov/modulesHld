package com.example.modularization.main_feature_api

import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.api.navigation.BaseArgument
import com.example.modularization.feature.core.api.navigation.CiceroneScreen
import kotlinx.android.parcel.Parcelize


@Doc.Api
interface MainRouter {
    /**
     * Перейти назад в рамках текущего таба.
     */
    fun navigateBack()

    /**
     * Перейти на [tab], если не null.
     * Перейти вперед на [screen]
     */
    fun navigateTo(screen: Screen, arg: BaseArgument? = null, tab: Tab? = null)

    /**
     * Перейти на [tab], если не null.
     * Установить новый root [screen]
     */
    fun newRootScreen(screen: Screen, tab: Tab? = null)

    /**
     * Перейти на [tab], если не null.
     * Установить новую цепочку экранов [screens]
     */
    fun newRootScreenChain(screens: List<Pair<Screen, BaseArgument?>>, tab: Tab? = null)

    /**
     * Перейти на [tab]
     */
    fun changeTab(tab: Tab)

    /**
     * Установить в [tab] новый root [screen]. Без перехода на этот tab.
     */
    fun resetTab(tab: Tab, screen: Screen, arg: BaseArgument? = null)

    /**
     * Перейти на [selectTab].
     * Установить в указанных табах новые root
     */
    fun resetTabs(selectTab: Tab, vararg tabSettings: Pair<Tab, Screen>)

    interface ScreensResolver {
        fun getScreenByFragmentName(fragmentName: String): Screen
    }

    enum class Tab(val tag: String) {
        Catalogue(TabNames.CATALOGUE),
        Cart(TabNames.CART)
    }

    sealed class Screen : CiceroneScreen {
        sealed class CatalogueFeature : Screen() {
            object Catalogue : CatalogueFeature()
            object SubCatalogue : CatalogueFeature()
        }

        sealed class PdpFeature : Screen() {
            object Pdp : PdpFeature() {
                @Parcelize
                data class Argument(val sku: Sku) : BaseArgument
            }
        }

        sealed class CartFeature : Screen() {
            object Cart : CartFeature()
        }
    }
}

