package com.example.modularization.feature.cart.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.cart.impl.screens.cart.CartFragment
import com.example.modularization.feature.main.api.MainRouter
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class CartFeatureFragmentProviderImpl @Inject constructor(
    private val cartFragment: Provider<CartFragment>,
) : CartFeatureFragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.CartFeature.Cart -> cartFragment.get()
        }
    }
}