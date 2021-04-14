package com.example.modularization.catalogue_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.main_feature_api.MainRouter

@DiDoc.Api
interface CatalogueFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment
}