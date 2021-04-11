package com.example.modularization.main_feature.router

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.navigation.BaseArgument

/**
 * Внутри MainFragment в контейнере лежат TabContainerFragment по количеству вкладок.
 * У каждого TabContainerFragment-а свой TabContainerRouter - классический линейный роутер с типовым RouterNavigator
 *
 * [MainRouterImpl] держит в себе
 * - TabContainerRouter каждого таба и знает какой таб активен.
 * - TabSwitcherRouter умеющий переключать табы.
 */
class MainRouterImpl(
    private val tabSwitcherRouter: TabSwitcherRouter,
    private val catalogueTabContainerRouter: TabContainerRouter,
    private val cartTabContainerRouter: TabContainerRouter,
) : MainRouter {

    private lateinit var activeTabContainerRouter: TabContainerRouter

    override fun navigateTo(screen: MainRouter.Screen, arg: BaseArgument?, tab: MainRouter.Tab?) {
        tab?.let { changeTab(it) }
        activeTabContainerRouter.navigateTo(screen, arg)
    }

    override fun navigateBack() {
        activeTabContainerRouter.navigateBack()
    }

    override fun newRootScreen(screen: MainRouter.Screen, tab: MainRouter.Tab?) {
        tab?.let { changeTab(it) }
        activeTabContainerRouter.newRootScreen(screen)
    }

    override fun changeTab(tab: MainRouter.Tab) {
        activeTabContainerRouter = getTabContainerRouter(tab)
        tabSwitcherRouter.changeTab(tab)
    }

    override fun resetTab(tab: MainRouter.Tab, screen: MainRouter.Screen, arg: BaseArgument?) {
        getTabContainerRouter(tab).newRootScreen(screen)
    }

    override fun resetTabs(
        selectTab: MainRouter.Tab,
        vararg tabSettings: Pair<MainRouter.Tab, MainRouter.Screen>
    ) {
        changeTab(selectTab)
        tabSettings.forEach { (tab, screen) ->
            getTabContainerRouter(tab).newRootScreen(screen)
        }
    }

    private fun getTabContainerRouter(tab: MainRouter.Tab): TabContainerRouter {
        return when (tab) {
            MainRouter.Tab.Catalogue -> catalogueTabContainerRouter
            MainRouter.Tab.Cart -> cartTabContainerRouter
        }
    }
}