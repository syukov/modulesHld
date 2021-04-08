package com.example.modularization.di

import android.content.Context
import com.example.modularization.activity.AppActivity
import com.example.modularization.di.childFeatures.rootFeature.RootFeatureProviderModule
import com.example.modularization.di.routerScreenToNameMappers.ScreenToNameMapperModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ComponentFactoryApiModule::class,
        RootFeatureProviderModule::class,
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


