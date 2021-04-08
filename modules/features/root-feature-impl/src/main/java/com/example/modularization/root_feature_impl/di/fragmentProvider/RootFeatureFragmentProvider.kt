package com.example.modularization.root_feature_impl.di.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_impl.screens.RootFragment
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import javax.inject.Inject
import javax.inject.Provider

class RootFeatureFragmentProvider @Inject constructor(
    private val rootFragment: Provider<RootFragment>
) : RootFeatureLauncher.FragmentProvider {
    override fun getRootFragment(): Fragment = rootFragment.get()
}