package com.example.modularization.feature.core.impl.navigation

import androidx.fragment.app.Fragment
import com.example.modularization.feature.core.api.navigation.CiceroneScreen

interface RouterFragmentCreator {
    fun getFragmentByScreen(screen: CiceroneScreen): Fragment
}