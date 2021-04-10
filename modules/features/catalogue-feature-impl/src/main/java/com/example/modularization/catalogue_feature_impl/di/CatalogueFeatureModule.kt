package com.example.modularization.catalogue_feature_impl.di

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature_impl.screens.catalogue.CatalogueFragment
import com.example.modularization.catalogue_feature_impl.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.main_feature_data.MainRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface CatalogueFeatureModule {
    companion object {
        @PerFeatureScope
        @Provides
        fun providerFragmentProvider(
            catalogueFragment: Provider<CatalogueFragment>,
            subCatalogueFragment: Provider<SubCatalogueFragment>,
        ): CatalogueFeatureComponent.FragmentProvider {
            return object : CatalogueFeatureComponent.FragmentProvider {
                override fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment {
                    return when (screen) {
                        MainRouter.Screen.CatalogueFeature.Catalogue -> catalogueFragment.get()
                        MainRouter.Screen.CatalogueFeature.SubCatalogue -> subCatalogueFragment.get()
                    }
                }
            }
        }
    }
}