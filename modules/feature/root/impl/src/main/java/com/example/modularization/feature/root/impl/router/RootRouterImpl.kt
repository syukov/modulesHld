package com.example.modularization.feature.root.impl.router

import com.example.modularization.feature.core.api.navigation.BaseArgument
import com.example.modularization.feature.core.impl.navigation.RouterCommand
import com.example.modularization.feature.root.api.RootRouter
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

