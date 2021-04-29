package com.example.modularization.feature.catalogue.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.catalogue.impl.screens.catalogue.CatalogueFragment
import com.example.modularization.feature.catalogue.impl.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.feature.main.api.MainRouter
import javax.inject.Inject
import javax.inject.Provider


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