package com.example.modularization.root_feature.router

import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.navigation.BaseArgument
import com.example.modularization.ui_core.navigation.RouterCommand
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class RootRouterImpl @Inject constructor() : BaseRouter(), RootRouter {

    override fun navigateTo(screen: RootRouter.Screen, arg: BaseArgument?) {
        executeCommands(RouterCommand.Forward(screen, arg))
    }

    override fun navigateBack() {
        executeCommands(RouterCommand.Back)
    }

    override fun newRootScreen(screen: RootRouter.Screen) {
        executeCommands(
            RouterCommand.BackTo(null),
            RouterCommand.Replace(screen)
        )
    }
}

