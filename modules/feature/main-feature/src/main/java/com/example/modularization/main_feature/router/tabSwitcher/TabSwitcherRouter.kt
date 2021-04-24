package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.main_feature_api.MainRouter
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

