package com.example.modularization.root_feature_impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_api.RootFeatureContract
import com.example.modularization.root_feature_impl.screens.RootFragment
import javax.inject.Inject
import javax.inject.Provider

class RootFeatureFragmentProvider @Inject constructor(
    private val rootFragment: Provider<RootFragment>
) : RootFeatureContract.FragmentProvider {
    override fun getFragment(): Fragment = rootFragment.get()
}