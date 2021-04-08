package com.example.modularization.root_feature_impl

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_impl.screens.RootFragment
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import javax.inject.Inject
import javax.inject.Provider

/**
 * Реализация кинтерфейса с помощью которого родительская фича получает фрагмент из текущей фичи, для отображения в своем контейнере.
 * В случае с RootFeature отдается только один RootFragment.
 */
class RootFeatureFragmentProvider @Inject constructor(
    private val rootFragment: Provider<RootFragment>
) : RootFeatureLauncher.FragmentProvider {
    override fun getRootFragment(): Fragment = rootFragment.get()
}