package com.example.modularization.root_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc

@Doc.Api
interface RootFeatureFragmentProvider {
    fun getRootFragment(): Fragment
}