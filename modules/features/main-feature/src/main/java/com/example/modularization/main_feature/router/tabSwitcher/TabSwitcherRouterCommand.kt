package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.navigation.CiceroneCommand

sealed class TabSwitcherRouterCommand : CiceroneCommand {
    data class Replace(val tab: MainRouter.Tab) : TabSwitcherRouterCommand()
}