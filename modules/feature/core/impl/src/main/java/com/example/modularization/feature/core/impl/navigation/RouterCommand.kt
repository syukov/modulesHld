package com.example.modularization.feature.core.impl.navigation

import com.example.modularization.feature.core.api.navigation.BaseArgument
import com.example.modularization.feature.core.api.navigation.CiceroneScreen

sealed class RouterCommand : CiceroneCommand {
    data class Forward(
        val screen: CiceroneScreen,
        val argument: BaseArgument? = null
    ) : RouterCommand()

    object Back : RouterCommand()

    data class BackTo(val screen: CiceroneScreen?) : RouterCommand()

    data class Replace(
        val screen: CiceroneScreen,
        val argument: BaseArgument? = null
    ) : RouterCommand()
}