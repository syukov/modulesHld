package com.example.modularization.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_impl.di.RootFeatureComponent
import javax.inject.Inject
import javax.inject.Provider

class AppActivityFragmentFactory @Inject constructor(
    private val rootFeatureComponentProvider: Provider<RootFeatureComponent>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootFeatureComponentProvider.get().getFragmentProvider().getRootFragment()
    }
}