package com.example.modularization.root_feature_api

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.ui_core.navigation.BaseArgument
import com.example.modularization.ui_core.navigation.CiceroneScreen


/**
 * Отвечает за контейнер расположденный в RootFragment.
 * Для добавления экрана нужно:
 */
@DiDoc.Api
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

