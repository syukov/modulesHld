package com.example.modularization.catalogue_feature_impl.di

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [CatalogueFeatureComponent.Dependencies::class],
    modules = [
        CatalogueFeatureModule::class
    ]
)
@PerFeatureScope
interface CatalogueFeatureComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(dependencies: Dependencies): CatalogueFeatureComponent
    }

    interface FragmentProvider {
        fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment
    }

    fun getFragmentProvider(): FragmentProvider

    interface Dependencies {
        fun rootRouter(): RootRouter
        fun mainRouter(): MainRouter
    }
}