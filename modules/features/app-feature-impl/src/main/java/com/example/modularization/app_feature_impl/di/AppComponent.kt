package com.example.modularization.app_feature_impl.di

import android.content.Context
import com.example.modularization.app_feature_impl.activity.AppActivity
import com.example.modularization.app_feature_impl.di.rootFeatureComponentProvider.RootFeatureComponentProviderModule
import com.example.modularization.app_feature_impl.di.routerScreenToNameMappers.ScreenToNameMapperModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AllComponentsFactoriesModule::class,
        RootFeatureComponentProviderModule::class,
        ScreenToNameMapperModule::class,
    ]
)
@PerApplicationScope
interface AppComponent {
    fun inject(activity: AppActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance appContext: Context
        ): AppComponent
    }
}


