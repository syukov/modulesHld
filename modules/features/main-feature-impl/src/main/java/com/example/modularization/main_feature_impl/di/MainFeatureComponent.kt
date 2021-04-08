package com.example.modularization.main_feature_impl.di

import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.main_feature_impl.screens.main.MainFragment
import dagger.Component

@Component(
    dependencies = [MainFeatureContract.Dependencies::class]
)
interface MainFeatureComponent : MainFeatureContract.Component {

    fun inject(fragment: MainFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(deps: MainFeatureContract.Dependencies): MainFeatureComponent
    }
}