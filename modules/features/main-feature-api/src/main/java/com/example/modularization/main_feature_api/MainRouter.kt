package com.example.modularization.main_feature_api

import com.example.modularization.ui_core.BaseArgument
import com.example.modularization.ui_core.CiceroneScreen


/**
 * Отвечает за контейнер расположденный в RootFragment.
 * Для добавления экрана нужно:
 */
interface MainRouter {

    fun navigateBack()

    fun navigateTo(screen: Screen, arg: BaseArgument? = null)

    fun newRootScreen(screen: Screen)

    interface ScreensResolver {
        fun getScreenByFragmentName(fragmentName: String): Screen
    }

    sealed class Screen : CiceroneScreen {
//        sealed class EmployeeProfileFeature : Screen() {
//            object EmployeeProfile : EmployeeProfileFeature()
//        }

        sealed class CatalogueFeature : Screen() {
            object Catalogue : CatalogueFeature()
            object SubCatalogue : CatalogueFeature()
        }

        sealed class PdpFeature : Screen() {
            object Pdp : PdpFeature()
        }
//
//        sealed class CartFeature : Screen() {
//            object Cart : CartFeature()
//        }
    }
}

