package com.example.modularization.core_feature.navigation

import com.example.modularization.core_feature_api.navigation.BaseArgument
import com.example.modularization.core_feature_api.navigation.CiceroneScreen

sealed class RouterCommand : CiceroneCommand {
    data class Forward(
        val screen: CiceroneScreen,
        val argument: BaseArgument? = null,
        val clearContainer: Boolean = true
    ) : RouterCommand()

    object Back : RouterCommand()

    data class BackTo(val screen: CiceroneScreen?) : RouterCommand()

    data class Replace(
        val screen: CiceroneScreen,
        val argument: BaseArgument? = null
    ) : RouterCommand()
}