package com.example.modularization.catalogue_feature.screens.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.catalogue_feature.databinding.FragmentCatalogueBinding
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class CatalogueFragment @Inject constructor(
    private val rootRouter: RootRouter
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCatalogueBinding.inflate(inflater).apply {
            subCatalogueBtn.setOnClickListener {
            }
        }.root
    }
}