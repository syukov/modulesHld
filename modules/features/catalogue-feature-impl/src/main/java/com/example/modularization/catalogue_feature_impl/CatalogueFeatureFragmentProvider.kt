package com.example.modularization.catalogue_feature_impl

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature_impl.screens.catalogue.CatalogueFragment
import com.example.modularization.catalogue_feature_impl.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.root_feature_data.MainRouter
import javax.inject.Inject
import javax.inject.Provider

/**
 * Реализация кинтерфейса с помощью которого родительская фича получает фрагмент из текущей фичи, для отображения в своем контейнере.
 */
class CatalogueFeatureFragmentProvider @Inject constructor(
    private val catalogueFragment: Provider<CatalogueFragment>,
    private val subCatalogueFragment: Provider<SubCatalogueFragment>,
) : CatalogueFeatureLauncher.FragmentProvider {
    override fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment {
        return when (screen) {
            MainRouter.Screen.CatalogueFeature.Catalogue -> catalogueFragment.get()
            MainRouter.Screen.CatalogueFeature.SubCatalogue -> subCatalogueFragment.get()
        }
    }
}