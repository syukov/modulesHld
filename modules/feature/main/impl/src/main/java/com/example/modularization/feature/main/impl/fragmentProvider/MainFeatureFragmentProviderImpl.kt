package com.example.modularization.feature.main.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.main.impl.screens.main.MainFragment
import com.example.modularization.feature.root.api.RootRouter
import javax.inject.Inject
import javax.inject.Provider


class MainFeatureFragmentProviderImpl @Inject constructor(
    private val mainFragment: Provider<MainFragment>,
) : MainFeatureFragmentProvider {
    override fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment {
        return when (screen) {
            RootRouter.Screen.MainFeature.Main -> mainFragment.get()
        }
    }
}