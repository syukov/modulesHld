package com.example.modularization.root_feature.router

import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.CiceroneCommand

sealed class RootRouterCommand : CiceroneCommand {
    object Back : RootRouterCommand()
    data class BackTo(val screen: RootRouter.Screen?) : RootRouterCommand()
    data class Forward(val screen: RootRouter.Screen, val clearContainer: Boolean = true) : RootRouterCommand()
    data class Replace(val screen: RootRouter.Screen) : RootRouterCommand()
}