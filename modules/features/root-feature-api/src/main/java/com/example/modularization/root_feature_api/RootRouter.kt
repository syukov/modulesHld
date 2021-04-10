package com.example.modularization.root_feature_api

import com.example.modularization.ui_core.BaseArgument
import com.example.modularization.ui_core.CiceroneScreen


/**
 * Отвечает за контейнер расположденный в RootFragment.
 * Для добавления экрана нужно:
 */
interface RootRouter {

    fun navigateTo(screen: Screen, arg: BaseArgument? = null)

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

