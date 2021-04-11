package com.example.modularization.main_feature.router

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature.di.CatalogueFeatureDi
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.di.PdpFeatureDi
import javax.inject.Inject
import javax.inject.Provider

/**
 * Этот класс умеет возвращать новый инстанс фрагмента по Router.Screen
 * Он используется для создания фрагмента двумя сущностями:
 *  - навигатором
 *  - фабрикой фрагментов (сначала фабрика по имени класса получает Router.Screen с помощью Router.ScreenResolver)
 */
class MainRouterFragmentResolver @Inject constructor(
    private val catalogueFeatureComponentProvider: Provider<CatalogueFeatureDi.FeatureComponent>,
    private val pdpFeatureComponentProvider: Provider<PdpFeatureDi.FeatureComponent>,
) {
    fun getFragmentByScreen(screen: MainRouter.Screen): Fragment {
        return when (screen) {
            is MainRouter.Screen.CatalogueFeature -> {
                catalogueFeatureComponentProvider.get().getFragmentProvider().getFragment(screen)
            }
            is MainRouter.Screen.PdpFeature -> {
                pdpFeatureComponentProvider.get().getFragmentProvider().getFragment(screen)
            }
        }
    }
}