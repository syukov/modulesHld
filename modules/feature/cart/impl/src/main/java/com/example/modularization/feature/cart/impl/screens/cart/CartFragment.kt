package com.example.modularization.feature.cart.impl.screens.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.feature.cart.impl.databinding.FragmentCartBinding
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.main.api.MainRouter
import javax.inject.Inject

class CartFragment @Inject constructor(
    private val mainRouter: MainRouter,
    private val cartDomainApi: CartDomainApi,
) : BaseFragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCartBinding.inflate(inflater).apply {
            binding = this
            clearCartBtn.setOnClickListener {
                runCase(
                    case = cartDomainApi.clearCart,
                    arg = Unit,
                ) { updateCartComposition() }
            }
            openPdpBtn.setOnClickListener { openPdp() }
        }.root
    }

    override fun onResume() {
        super.onResume()
        updateCartComposition()
    }

    private fun updateCartComposition() {
        runCase(
            case = cartDomainApi.getCart,
            arg = Unit,
        ) {
            binding.cartCompositionTV.text = it.toString()
            binding.openPdpBtn.isVisible = it.products.isNotEmpty()
        }
    }

    private fun openPdp() {
        runCase(
            case = cartDomainApi.getCart,
            arg = Unit,
        ) { cart ->
            val firstProduct = cart.products.first()

            mainRouter.newRootScreenChain(
                listOf(
                    MainRouter.Screen.CatalogueFeature.Catalogue to null,
                    MainRouter.Screen.CatalogueFeature.SubCatalogue to null,
                    MainRouter.Screen.PdpFeature.Pdp to MainRouter.Screen.PdpFeature.Pdp.Argument(firstProduct.sku)
                ),
                MainRouter.Tab.Catalogue
            )
        }
    }
}