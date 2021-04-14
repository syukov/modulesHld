package com.example.modularization.core_feature.navigation

import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.Cicerone


val BaseRouter.navigatorHolder
    get() = Cicerone.create(this).getNavigatorHolder()