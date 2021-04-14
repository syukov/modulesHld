package com.example.modularization.main_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.main_feature.screens.main.MainFragment
import com.example.modularization.root_feature_api.RootRouter
import javax.inject.Inject
import javax.inject.Provider

@DiDoc.Api.Implementation
class MainFeatureFragmentProviderImpl @Inject constructor(
    private val mainFragment: Provider<MainFragment>,
) : MainFeatureFragmentProvider {
    override fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment {
        return when (screen) {
            RootRouter.Screen.MainFeature.Main -> mainFragment.get()
        }
    }
}