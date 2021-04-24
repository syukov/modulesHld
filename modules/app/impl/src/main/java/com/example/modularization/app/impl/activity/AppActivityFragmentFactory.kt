package com.example.modularization.app.impl.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.feature.root.impl.di.RootFeatureDi
import javax.inject.Inject
import javax.inject.Provider

class AppActivityFragmentFactory @Inject constructor(
    private val rootFeatureComponentProvider: Provider<RootFeatureDi.DiComponent>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootFeatureComponentProvider.get().fragmentProvider.getRootFragment()
    }
}