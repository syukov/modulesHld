package com.example.modularization.main_feature_impl

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature_impl.screens.main.MainFragment
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject
import javax.inject.Provider

/**
 * Реализация кинтерфейса с помощью которого родительская фича получает фрагмент из текущей фичи, для отображения в своем контейнере.
 */
class MainFeatureFragmentProvider @Inject constructor(
    private val mainFragment: Provider<MainFragment>,
) : MainFeatureLauncher.FragmentProvider {
    override fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment {
        return when (screen) {
            RootRouter.Screen.MainFeature.Main -> mainFragment.get()
        }
    }
}