package com.example.modularization.cart_feature.screens.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.cart_feature.databinding.FragmentCartBinding
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class CartFragment @Inject constructor(
    private val mainRouter: MainRouter
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCartBinding.inflate(inflater).apply {
        }.root
    }
}