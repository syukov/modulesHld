package com.example.modularization.di.entireAppDependencies

import com.example.modularization.catalogue_feature_impl.screens.catalogue.CatalogueFragment
import com.example.modularization.catalogue_feature_impl.screens.subCatalogue.SubCatalogueFragment
import com.example.modularization.di.PerApplicationScope
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.ui_core.utils.checkWhenBranches
import dagger.Module
import dagger.Provides

@Module
class MainRouterFragmentsResolverModule {
    /**
     * Хук с рефлексией для того что бы компилятор нам подсказал если мы создали Screen и забыли указать ему имя фрагмента
     */
    private val fragmentsMap: Map<String, MainRouter.Screen> = mutableMapOf<String, MainRouter.Screen>().apply {
        MainRouter.Screen::class.sealedSubclasses
            .mapNotNull { it.objectInstance }
            .forEach {
                when (it) {
                    MainRouter.Screen.CatalogueFeature.Catalogue -> put(CatalogueFragment::class.java.name, it)
                    MainRouter.Screen.CatalogueFeature.SubCatalogue -> put(SubCatalogueFragment::class.java.name, it)
                }.checkWhenBranches
            }
    }


    @PerApplicationScope
    @Provides
    fun provideScreenFeatureResolver() = object : MainRouter.ScreensResolver {
        override fun getScreenByFragmentName(fragmentName: String): MainRouter.Screen {
            return fragmentsMap[fragmentName]
                ?: throw UnsupportedOperationException("$fragmentName should be registered in ${MainRouterFragmentsResolverModule::class.simpleName} to be opened in MainRouter")
        }
    }
}

