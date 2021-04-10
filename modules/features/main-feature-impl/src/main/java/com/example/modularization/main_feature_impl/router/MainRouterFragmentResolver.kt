package com.example.modularization.main_feature_impl.router

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature_impl.di.CatalogueFeatureComponent
import com.example.modularization.main_feature_data.MainRouter
import javax.inject.Inject
import javax.inject.Provider

/**
 * Этот класс умеет возвращать новый инстанс фрагмента по Router.Screen
 * Он используется для создания фрагмента двумя сущностями:
 *  - навигатором
 *  - фабрикой фрагментов (сначала фабрика по имени класса получает Router.Screen с помощью Router.ScreenResolver)
 */
class MainRouterFragmentResolver @Inject constructor(
    private val catalogueFeatureComponentApiProvider: Provider<CatalogueFeatureComponent>,
    // TODO: добавляем сюда провайдеры FeatureLauncher.ComponentApi всех вложенных фич
) {
    fun getFragmentByScreen(screen: MainRouter.Screen): Fragment {
        return when (screen) {
            is MainRouter.Screen.CatalogueFeature -> {
                catalogueFeatureComponentApiProvider.get().getFragmentProvider().getFragment(screen)
            }
        }
    }
}