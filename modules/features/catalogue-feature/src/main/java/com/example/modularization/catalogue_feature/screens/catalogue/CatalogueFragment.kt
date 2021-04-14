package com.example.modularization.catalogue_feature.screens.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.catalogue_feature.databinding.FragmentCatalogueBinding
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.main_feature_api.MainRouter
import javax.inject.Inject

class CatalogueFragment @Inject constructor(
    private val mainRouter: MainRouter
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCatalogueBinding.inflate(inflater).apply {
            subCatalogueBtn.setOnClickListener {
                mainRouter.navigateTo(MainRouter.Screen.CatalogueFeature.SubCatalogue)
            }
        }.root
    }
}