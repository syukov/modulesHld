package com.example.modularization.app_feature_impl.di.rootFeatureComponentProvider

import android.content.Context
import com.example.modularization.employee_auth_feature_api.EmployeeAuthFeatureContract
import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.root_feature_api.RootFeatureContract
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject

/**
 * В этом классе описываем имплементацию нтерфейса FeatureContract.Dependencies.
 * Делаем это в том градл модуле который будет непосредственно запускать фичу в своем контейнере.
 */
class RootFeatureDependenciesImpl @Inject constructor(
    private val appContext: Context,
    private val rootRouterScreenToNameMapper: RootRouter.ScreenToNameMapper,
    private val employeeAuthFeatureContractComponentFactory: EmployeeAuthFeatureContract.ComponentFactory,
    private val mainFeatureContractComponentFactory: MainFeatureContract.ComponentFactory,
) : RootFeatureContract.Dependencies {
    override fun rootRouterScreenToNameMapper(): RootRouter.ScreenToNameMapper = rootRouterScreenToNameMapper

    override fun appContext(): Context = appContext

    override fun employeeAuthFeatureComponentFactory(): EmployeeAuthFeatureContract.ComponentFactory =
        employeeAuthFeatureContractComponentFactory

    override fun mainFeatureComponentFactory(): MainFeatureContract.ComponentFactory =
        mainFeatureContractComponentFactory
}