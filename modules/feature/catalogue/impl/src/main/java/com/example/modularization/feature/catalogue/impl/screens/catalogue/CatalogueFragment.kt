package com.example.modularization.feature.catalogue.impl.screens.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.catalogue.impl.databinding.FragmentCatalogueBinding
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.root.api.RootRouter
import javax.inject.Inject

class CatalogueFragment @Inject constructor(
    private val mainRouter: MainRouter,
    private val rootRouter: RootRouter,
    private val securityDomainApi: SecurityDomainApi,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCatalogueBinding.inflate(inflater).apply {
            subCatalogueBtn.setOnClickListener {
                mainRouter.navigateTo(MainRouter.Screen.CatalogueFeature.SubCatalogue)
            }

            logoutBtn.setOnClickListener {
                runCase(
                    case = securityDomainApi.logout,
                    arg = Unit
                ) { rootRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.Login) }
            }
        }.root
    }
}