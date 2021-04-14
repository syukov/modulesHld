package com.example.modularization.pdp_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.screens.pdp.PdpFragment
import javax.inject.Inject
import javax.inject.Provider

@DiDoc.Api.Implementation
class PdpFeatureFragmentProviderImpl @Inject constructor(
    private val pdpFragment: Provider<PdpFragment>,
) : PdpFeatureFragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.PdpFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.PdpFeature.Pdp -> pdpFragment.get()
        }
    }
}