package com.example.modularization.catalogue_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.catalogue_feature.screens.catalogue.CatalogueFragment
import com.example.modularization.catalogue_feature.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.main_feature_api.MainRouter
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class CatalogueFeatureFragmentProviderImpl @Inject constructor(
    private val catalogueFragment: Provider<CatalogueFragment>,
    private val subCatalogueFragment: Provider<SubCatalogueFragment>,
) : CatalogueFeatureFragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.CatalogueFeature.Catalogue -> catalogueFragment.get()
            MainRouter.Screen.CatalogueFeature.SubCatalogue -> subCatalogueFragment.get()
        }
    }
}