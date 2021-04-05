package com.example.modularization.app_feature_impl.appRouter

import com.example.modularization.app_feature_api.data.AppRouter

sealed class AppRouterCommands : CiceroneCommand {
    object Back : AppRouterCommands()
    data class BackTo(val screen: AppRouter.Screen?) : AppRouterCommands()
    data class Forward(val screen: AppRouter.Screen, val clearContainer: Boolean = true) : AppRouterCommands()
    data class Replace(val screen: AppRouter.Screen) : AppRouterCommands()
}