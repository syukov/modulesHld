package com.example.modularization.ui_core.navigation

import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.Cicerone

typealias CiceroneScreen = com.github.terrakok.cicerone.Screen
typealias CiceroneCommand = com.github.terrakok.cicerone.Command


val BaseRouter.navigatorHolder
    get() = Cicerone.create(this).getNavigatorHolder()