package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.core_feature.navigation.RouterCommand
import com.example.modularization.core_feature_api.navigation.BaseArgument
import com.example.modularization.main_feature_api.MainRouter
import com.github.terrakok.cicerone.BaseRouter
import javax.inject.Inject

/**
 * Отвечает за навигацию внутри одного TabContainerFragment.
 * Работает с типовым RouterNavigator.
 */
class TabContainerRouter @Inject constructor(
    val tab: MainRouter.Tab
) : BaseRouter() {

    fun navigateTo(
        screen: MainRouter.Screen,
        arg: BaseArgument?
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

    fun newRootScreenChain(screensToArg: List<Pair<MainRouter.Screen, BaseArgument?>>) {
        val (newRootScreen, newRootScreenArg) = screensToArg.first()

        executeCommands(
            RouterCommand.BackTo(null),
            RouterCommand.Replace(newRootScreen, newRootScreenArg),
            *(screensToArg.drop(1)
                .map { (screen, arg) ->
                    RouterCommand.Forward(screen, arg)
                }
                .toTypedArray())
        )
    }
}

