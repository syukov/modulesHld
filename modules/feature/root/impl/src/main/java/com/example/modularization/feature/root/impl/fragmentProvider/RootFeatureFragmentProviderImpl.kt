package com.example.modularization.feature.root.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.root.impl.screens.RootFragment
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class RootFeatureFragmentProviderImpl @Inject constructor(
    private val rootFragmentProvider: Provider<RootFragment>,
) : RootFeatureFragmentProvider {
    override fun getRootFragment(): Fragment = rootFragmentProvider.get()
}