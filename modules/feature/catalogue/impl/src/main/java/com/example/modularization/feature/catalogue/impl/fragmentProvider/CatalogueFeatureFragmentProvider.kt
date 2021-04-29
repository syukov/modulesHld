package com.example.modularization.feature.catalogue.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.main.api.MainRouter


interface CatalogueFeatureFragmentProvider {
    fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment
}