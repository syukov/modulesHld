package com.example.modularization.ui_core.navigation

import androidx.fragment.app.Fragment

interface RouterFragmentCreator {
    fun getFragmentByScreen(screen: CiceroneScreen): Fragment
}