package com.example.modularization.xxx_feature_impl.di

import dagger.Component

@Component(
    dependencies = [XxxFeatureContract.Dependencies::class]
)
interface XxxFeatureComponent : XxxFeatureContract.Component {

    fun inject(fragment: XxxFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(deps: XxxFeatureContract.Dependencies): XxxFeatureComponent
    }
}