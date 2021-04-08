package com.example.modularization.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import javax.inject.Inject
import javax.inject.Provider

/**
 * В AppActivity всегда располагается только один RootFragment.
 * Это сделано для того что бы максимально упростить app модуль, т.к. он будет пересобираться при любом изменении в приложении.
 */
class AppActivityFragmentFactory @Inject constructor(
    private val rootFeatureComponentApiProvider: Provider<RootFeatureLauncher.ComponentApi>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootFeatureComponentApiProvider.get().getFragmentProvider().getRootFragment()
    }
}