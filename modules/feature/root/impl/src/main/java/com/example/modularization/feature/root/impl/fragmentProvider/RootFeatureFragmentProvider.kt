package com.example.modularization.feature.root.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc

@Doc.Api
interface RootFeatureFragmentProvider {
    fun getRootFragment(): Fragment
}