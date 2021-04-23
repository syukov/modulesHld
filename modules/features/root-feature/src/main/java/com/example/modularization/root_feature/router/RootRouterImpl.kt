package com.example.modularization.root_feature.router

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.core_feature.navigation.RouterCommand
import com.example.modularization.core_feature_api.navigation.BaseArgument
import com.example.modularization.root_feature_api.RootRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

@Doc.Api.Implementation
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

