package com.example.modularization.main_feature.router

import androidx.fragment.app.Fragment
import com.example.modularization.cart_feature.di.CartFeatureDi
import com.example.modularization.catalogue_feature.di.CatalogueFeatureDi
import com.example.modularization.feature.core.api.navigation.CiceroneScreen
import com.example.modularization.feature.core.impl.navigation.RouterFragmentCreator
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
class MainRouterFragmentCreator @Inject constructor(
    private val catalogueFeatureComponentProvider: Provider<CatalogueFeatureDi.DiComponent>,
    private val pdpFeatureComponentProvider: Provider<PdpFeatureDi.DiComponent>,
    private val cartFeatureComponentProvider: Provider<CartFeatureDi.DiComponent>,
) : RouterFragmentCreator {
    override fun getFragmentByScreen(screen: CiceroneScreen): Fragment {
        if (screen !is MainRouter.Screen) throw UnsupportedOperationException("Root router is able to open only MainRouter.Screen but not ${screen::class.java.name}")
        return when (screen) {
            is MainRouter.Screen.CatalogueFeature -> {
                catalogueFeatureComponentProvider.get().fragmentProvider.getFragment(screen)
            }
            is MainRouter.Screen.PdpFeature -> {
                pdpFeatureComponentProvider.get().getFragmentProvider().getFragment(screen)
            }
            is MainRouter.Screen.CartFeature -> {
                cartFeatureComponentProvider.get().fragmentProvider.getFragment(screen)
            }
        }
    }
}