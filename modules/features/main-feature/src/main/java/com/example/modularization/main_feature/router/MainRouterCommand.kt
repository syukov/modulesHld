package com.example.modularization.main_feature.router

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.CiceroneCommand

sealed class MainRouterCommand : CiceroneCommand {
    object Back : MainRouterCommand()
    data class BackTo(val screen: MainRouter.Screen?) : MainRouterCommand()
    data class Forward(val screen: MainRouter.Screen, val clearContainer: Boolean = true) : MainRouterCommand()
    data class Replace(val screen: MainRouter.Screen) : MainRouterCommand()
}