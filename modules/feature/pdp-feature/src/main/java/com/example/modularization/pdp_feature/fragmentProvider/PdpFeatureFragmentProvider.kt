package com.example.modularization.pdp_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature_api.MainRouter

interface PdpFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.PdpFeature): Fragment
}