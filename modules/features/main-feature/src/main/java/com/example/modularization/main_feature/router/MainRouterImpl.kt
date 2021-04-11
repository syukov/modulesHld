package com.example.modularization.main_feature.router

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.BaseArgument
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor() : BaseRouter(), MainRouter {

    override fun navigateTo(screen: MainRouter.Screen, arg: BaseArgument?) {
        executeCommands(MainRouterCommand.Forward(screen))
    }

    override fun navigateBack() {
        executeCommands(MainRouterCommand.Back)
    }

    override fun newRootScreen(screen: MainRouter.Screen) {
        executeCommands(
            MainRouterCommand.BackTo(null),
            MainRouterCommand.Replace(screen)
        )
    }
}

