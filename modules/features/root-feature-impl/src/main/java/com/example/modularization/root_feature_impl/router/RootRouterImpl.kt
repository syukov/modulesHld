package com.example.modularization.root_feature_impl.router

import com.example.modularization.root_feature_data.RootRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class RootRouterImpl @Inject constructor() : BaseRouter(), RootRouter {

    override fun navigateTo(screen: RootRouter.Screen) {
        executeCommands(RootRouterCommand.Forward(screen))
    }

    override fun newRootScreen(screen: RootRouter.Screen) {
        executeCommands(
            RootRouterCommand.BackTo(null),
            RootRouterCommand.Replace(screen)
        )
    }
}

