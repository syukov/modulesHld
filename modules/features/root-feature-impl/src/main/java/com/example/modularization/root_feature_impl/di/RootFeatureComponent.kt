package com.example.modularization.root_feature_impl.di

import com.example.modularization.root_feature_api.RootFeatureContract
import com.example.modularization.root_feature_impl.screens.RootFragment
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [RootFeatureContract.Dependencies::class],
    modules = [
        RouterModule::class,
        RootFeatureModule::class
    ]
)
@PerFeatureScope
interface RootFeatureComponent : RootFeatureContract.Component {

    fun inject(fragment: RootFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(dependencies: RootFeatureContract.Dependencies): RootFeatureComponent
    }
}