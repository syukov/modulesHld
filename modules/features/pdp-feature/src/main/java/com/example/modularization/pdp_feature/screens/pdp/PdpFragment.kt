package com.example.modularization.pdp_feature.screens.pdp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.databinding.FragmentPdpBinding
import javax.inject.Inject

class PdpFragment @Inject constructor(
    private val mainRouter: MainRouter
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentPdpBinding.inflate(inflater).apply {
            toCart.setOnClickListener {
                activity?.let {
                    it.finish()
                    it.startActivity(Intent(it, it::class.java))
                }
            }
        }.root
    }
}