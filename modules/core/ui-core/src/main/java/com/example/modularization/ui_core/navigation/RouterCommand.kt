package com.example.modularization.ui_core.navigation

sealed class RouterCommand : CiceroneCommand {
    data class Forward(
        val screen: CiceroneScreen,
        val argument: BaseArgument? = null,
        val clearContainer: Boolean = true
    ) : RouterCommand()

    object Back : RouterCommand()

    data class BackTo(val screen: CiceroneScreen?) : RouterCommand()

    data class Replace(val screen: CiceroneScreen, val argument: BaseArgument? = null) : RouterCommand()
}