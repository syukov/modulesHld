package com.example.modularization.di

import android.content.Context
import com.example.modularization.activity.AppActivity
import com.example.modularization.di.entireAppDependencies.ComponentFactoryApiModule
import com.example.modularization.di.entireAppDependencies.MainRouterFragmentsResolverModule
import com.example.modularization.di.entireAppDependencies.RootRouterFragmentsResolverModule
import com.example.modularization.di.nestedFeatureProviders.RootFeatureProviderModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ComponentFactoryApiModule::class,
        RootFeatureProviderModule::class,
        RootRouterFragmentsResolverModule::class,
        MainRouterFragmentsResolverModule::class,
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


