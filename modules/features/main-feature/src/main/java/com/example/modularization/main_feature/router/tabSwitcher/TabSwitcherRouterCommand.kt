package com.example.modularization.main_feature.router.tabSwitcher

import com.example.modularization.core_feature.navigation.CiceroneCommand
import com.example.modularization.main_feature_api.MainRouter

sealed class TabSwitcherRouterCommand : CiceroneCommand {
    data class Replace(val tab: MainRouter.Tab) : TabSwitcherRouterCommand()
}