package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.core_feature.navigation.RouterCommand
import com.example.modularization.main_feature_api.MainRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

/**
 * Отвечает за навигацию внутри одного TabContainerFragment.
 * Работает с типовым RouterNavigator.
 */
class TabContainerRouter @Inject constructor(
    private val tab: MainRouter.Tab
) : BaseRouter() {

    fun navigateTo(
        screen: MainRouter.Screen,
        arg: com.example.modularization.core_feature_api.navigation.BaseArgument?
    ) {
        executeCommands(RouterCommand.Forward(screen, arg))
    }

    fun navigateBack() {
        executeCommands(RouterCommand.Back)
    }

    fun newRootScreen(screen: MainRouter.Screen) {
        executeCommands(
            RouterCommand.BackTo(null),
            RouterCommand.Replace(screen)
        )
    }
}

