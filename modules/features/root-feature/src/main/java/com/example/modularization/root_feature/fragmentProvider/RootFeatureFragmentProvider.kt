package com.example.modularization.root_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc

@DiDoc.Api
interface RootFeatureFragmentProvider {
    fun getRootFragment(): Fragment
}