package com.example.modularization.feature.main.impl.router.tabSwitcher

import com.example.modularization.feature.core.impl.navigation.CiceroneCommand
import com.example.modularization.feature.main.api.MainRouter

sealed class TabSwitcherRouterCommand : CiceroneCommand {
    data class Replace(val tab: MainRouter.Tab) : TabSwitcherRouterCommand()
}