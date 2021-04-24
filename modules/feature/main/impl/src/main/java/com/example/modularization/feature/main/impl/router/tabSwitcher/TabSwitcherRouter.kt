package com.example.modularization.feature.main.impl.router.tabSwitcher

import com.example.modularization.feature.main.api.MainRouter
import com.github.terrakok.cicerone.BaseRouter

/**
 * Отвечает за переключение видимости TabContainerFragment-ов.
 * Работает с TabSwitcherRouterNavigator.
 */
class TabSwitcherRouter : BaseRouter() {
    fun changeTab(tab: MainRouter.Tab) {
        executeCommands(TabSwitcherRouterCommand.Replace(tab))
    }
}

