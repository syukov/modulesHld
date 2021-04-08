package com.example.modularization.main_feature_impl.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.main_feature_impl.databinding.FragmentMainBinding
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val rootRouter: RootRouter
) : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).root.also {
            //TODO: реализовать mainFragment
        }
    }
}