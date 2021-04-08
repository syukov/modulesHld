package com.example.modularization.app_feature_impl.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_api.RootFeatureContract
import javax.inject.Inject
import javax.inject.Provider

/**
 * В AppActivity всегда располагается только один RootFragment.
 * Это сделано для того что бы максимально упростить app модуль, т.к. он будет пересобираться при любом изменении в приложении.
 */
class AppActivityFragmentFactory @Inject constructor(
    private val rootFeatureComponentProvider: Provider<RootFeatureContract.Component>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootFeatureComponentProvider.get().getFragmentProvider().getFragment()
    }
}