package com.example.modularization.app_feature_impl.appRouter

import com.example.modularization.app_feature_api.data.AppRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

class AppRouterImpl @Inject constructor(
) : BaseRouter(), AppRouter {
    override fun navigate(command: AppRouter.Command) {
        executeCommands(command)
    }
}

