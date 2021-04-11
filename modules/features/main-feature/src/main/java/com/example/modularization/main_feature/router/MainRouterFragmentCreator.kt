package com.example.modularization.main_feature.router

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature.di.CatalogueFeatureDi
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.di.PdpFeatureDi
import com.example.modularization.ui_core.navigation.CiceroneScreen
import com.example.modularization.ui_core.navigation.RouterFragmentCreator
import javax.inject.Inject
import javax.inject.Provider

/**
 * Этот класс умеет возвращать новый инстанс фрагмента по Router.Screen
 * Он используется для создания фрагмента двумя сущностями:
 *  - навигатором
 *  - фабрикой фрагментов (сначала фабрика по имени класса получает Router.Screen с помощью Router.ScreenResolver)
 */
class MainRouterFragmentCreator @Inject constructor(
    private val catalogueFeatureComponentProvider: Provider<CatalogueFeatureDi.FeatureComponent>,
    private val pdpFeatureComponentProvider: Provider<PdpFeatureDi.FeatureComponent>,
) : RouterFragmentCreator {
    override fun getFragmentByScreen(screen: CiceroneScreen): Fragment {
        if (screen !is MainRouter.Screen) throw UnsupportedOperationException("Root router is able to open only MainRouter.Screen but not ${screen::class.java.name}")
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