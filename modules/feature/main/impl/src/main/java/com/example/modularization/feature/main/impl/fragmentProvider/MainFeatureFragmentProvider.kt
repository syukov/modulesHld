package com.example.modularization.feature.main.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_api.RootRouter

interface MainFeatureFragmentProvider {
    fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment
}