package com.example.modularization.app_feature_impl.appRouter

import com.example.modularization.app_feature_api.data.AppRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

typealias CiceroneCommand = com.github.terrakok.cicerone.Command

class AppRouterImpl @Inject constructor(
) : BaseRouter(), AppRouter {

    override fun navigateTo(screen: AppRouter.Screen) {
        executeCommands(AppRouterCommands.Forward(screen))
    }

    override fun newRootScreen(screen: AppRouter.Screen) {
        executeCommands(
            AppRouterCommands.BackTo(null),
            AppRouterCommands.Replace(screen)
        )
    }
}

