package com.example.modularization.core_feature.navigation

import androidx.fragment.app.Fragment
import com.example.modularization.core_feature_api.navigation.CiceroneScreen

interface RouterFragmentCreator {
    fun getFragmentByScreen(screen: CiceroneScreen): Fragment
}