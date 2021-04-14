package com.example.modularization.main_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_api.RootRouter

interface MainFeatureFragmentProvider {
    fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment
}