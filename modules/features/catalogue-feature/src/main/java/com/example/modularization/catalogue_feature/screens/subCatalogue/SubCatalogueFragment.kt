package com.example.modularization.catalogue_feature.screens.subCatalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.catalogue_feature.databinding.FragmentSubCatalogueBinding
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.main_feature_api.MainRouter
import javax.inject.Inject

class SubCatalogueFragment @Inject constructor(
    private var mainRouter: MainRouter,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentSubCatalogueBinding.inflate(inflater).apply {
            pdpBtn.setOnClickListener {
                mainRouter.navigateTo(MainRouter.Screen.PdpFeature.Pdp)
            }
        }.root
    }
}