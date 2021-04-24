package com.example.modularization.feature.pdp.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.main.api.MainRouter

interface PdpFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.PdpFeature): Fragment
}