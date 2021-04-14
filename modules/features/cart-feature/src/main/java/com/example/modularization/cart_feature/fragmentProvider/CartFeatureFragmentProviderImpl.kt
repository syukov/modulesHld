package com.example.modularization.cart_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.cart_feature.screens.cart.CartFragment
import com.example.modularization.main_feature_api.MainRouter
import javax.inject.Inject
import javax.inject.Provider

@DiDoc.Api.Implementation
class CartFeatureFragmentProviderImpl @Inject constructor(
    private val cartFragment: Provider<CartFragment>,
) : CartFeatureFragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.CartFeature.Cart -> cartFragment.get()
        }
    }
}