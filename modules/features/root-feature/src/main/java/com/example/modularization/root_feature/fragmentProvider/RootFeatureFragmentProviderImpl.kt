package com.example.modularization.root_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.root_feature.screens.RootFragment
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class RootFeatureFragmentProviderImpl @Inject constructor(
    private val rootFragmentProvider: Provider<RootFragment>,
) : RootFeatureFragmentProvider {
    override fun getRootFragment(): Fragment = rootFragmentProvider.get()
}