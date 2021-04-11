package com.example.modularization.main_feature.router

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.navigation.BaseArgument
import com.example.modularization.ui_core.navigation.RouterCommand
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor() : BaseRouter(), MainRouter {

    override fun navigateTo(screen: MainRouter.Screen, arg: BaseArgument?) {
        executeCommands(RouterCommand.Forward(screen, arg))
    }

    override fun navigateBack() {
        executeCommands(RouterCommand.Back)
    }

    override fun newRootScreen(screen: MainRouter.Screen) {
        executeCommands(
            RouterCommand.BackTo(null),
            RouterCommand.Replace(screen)
        )
    }
}

