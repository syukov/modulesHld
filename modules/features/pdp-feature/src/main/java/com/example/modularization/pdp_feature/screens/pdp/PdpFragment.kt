package com.example.modularization.pdp_feature.screens.pdp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.modularization.app.api.aliases.Sku
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.core_feature_api.navigation.BaseArgument
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.databinding.FragmentPdpBinding
import java.util.*
import javax.inject.Inject

class PdpFragment @Inject constructor(
    private val mainRouter: MainRouter,
    private val cartDomainApi: CartDomainApi,
    private val appDomainApi: AppDomainApi,
) : BaseFragment() {

    private var sku: Sku? = null

    override fun onArgument(arg: BaseArgument) {
        super.onArgument(arg as MainRouter.Screen.PdpFeature.Pdp.Argument)
        sku = arg.sku
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentPdpBinding.inflate(inflater).apply {
            skuTV.text = sku?.value

            toCart.setOnClickListener {
                runCase(
                    case = cartDomainApi.addProduct,
                    arg = sku ?: return@setOnClickListener,
                ) {
                    Toast.makeText(appDomainApi.appContext, "product has been added", Toast.LENGTH_SHORT).show()
                }
            }
        }.root
    }
}