package com.example.modularization.employee_auth_feature_impl.screens.deugTools

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.employee_auth_feature_api.EmployeeAuthFeatureContract
import com.example.modularization.employee_auth_feature_impl.databinding.FragmentDebugToolsBinding
import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class DebugToolsFragment() : BaseFragment(),
    RootRouter.ScreenFragment,
    EmployeeAuthFeatureContract.ComponentInjector, Parcelable {

    @Inject
    lateinit var appRouter: RootRouter

    constructor(parcel: Parcel) : this() {

    }

    override fun getScreen(): RootRouter.Screen = RootRouter.Screen.EmployeeAuthFeature.DebugTools

    override fun inject(component: EmployeeAuthFeatureContract.Component) {
        (component as DaggerEmployeeAuthFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentDebugToolsBinding.inflate(inflater).apply {
            loginBtn.setOnClickListener {
                appRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.Login)
            }
            mainBtn.setOnClickListener {
                appRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DebugToolsFragment> {
        override fun createFromParcel(parcel: Parcel): DebugToolsFragment {
            return DebugToolsFragment(parcel)
        }

        override fun newArray(size: Int): Array<DebugToolsFragment?> {
            return arrayOfNulls(size)
        }
    }
}