package com.example.modularization.catalogue_feature_impl.screens.subCatalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.catalogue_feature_impl.databinding.FragmentSubCatalogueBinding
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class SubCatalogueFragment @Inject constructor(
    private var rootRouter: RootRouter,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentSubCatalogueBinding.inflate(inflater).apply {
            pdpBtn.setOnClickListener {
//                rootRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }
}