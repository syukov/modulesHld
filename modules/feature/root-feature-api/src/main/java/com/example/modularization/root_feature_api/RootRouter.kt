package com.example.modularization.root_feature_api

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.api.navigation.BaseArgument
import com.example.modularization.feature.core.api.navigation.CiceroneScreen


/**
 * Отвечает за контейнер расположденный в RootFragment.
 * Для добавления экрана нужно:
 */
@Doc.Api
interface RootRouter {

    fun navigateTo(screen: Screen, arg: BaseArgument? = null)

    fun navigateBack()

    fun newRootScreen(screen: Screen)

    interface ScreensResolver {
        fun getScreenByFragmentName(fragmentName: String): Screen
    }

    sealed class Screen : CiceroneScreen {
        sealed class EmployeeAuthFeature : Screen() {
            object Login : EmployeeAuthFeature()
            object DebugTools : EmployeeAuthFeature()
        }

        sealed class MainFeature : Screen() {
            object Main : MainFeature()
        }
    }
}

