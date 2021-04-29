package com.example.modularization.feature.cart.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.main.api.MainRouter


interface CartFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment
}