package com.example.modularization.feature.cart.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.main_feature_api.MainRouter

@Doc.Api
interface CartFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment
}