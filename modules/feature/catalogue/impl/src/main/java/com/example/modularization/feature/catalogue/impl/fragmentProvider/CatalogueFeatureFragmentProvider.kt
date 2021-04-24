package com.example.modularization.feature.catalogue.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.main.api.MainRouter

@Doc.Api
interface CatalogueFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment
}