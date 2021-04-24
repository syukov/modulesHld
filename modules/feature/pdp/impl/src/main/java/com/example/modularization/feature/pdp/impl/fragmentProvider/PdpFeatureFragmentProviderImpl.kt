package com.example.modularization.feature.pdp.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.pdp.impl.screens.pdp.PdpFragment
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class PdpFeatureFragmentProviderImpl @Inject constructor(
    private val pdpFragment: Provider<PdpFragment>,
) : PdpFeatureFragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.PdpFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.PdpFeature.Pdp -> pdpFragment.get()
        }
    }
}