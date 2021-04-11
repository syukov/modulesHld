package com.example.modularization.root_feature.router

import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.BaseArgument
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class RootRouterImpl @Inject constructor() : BaseRouter(), RootRouter {

    override fun navigateTo(screen: RootRouter.Screen, arg: BaseArgument?) {
        executeCommands(RootRouterCommand.Forward(screen))
    }

    override fun navigateBack() {
        executeCommands(RootRouterCommand.Back)
    }

    override fun newRootScreen(screen: RootRouter.Screen) {
        executeCommands(
            RootRouterCommand.BackTo(null),
            RootRouterCommand.Replace(screen)
        )
    }
}

