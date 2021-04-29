package com.example.modularization.app.impl.di

import android.content.Context
import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.app.impl.activity.AppActivity
import com.example.modularization.app.impl.moduleApi.AppDomainApiDiModule
import dagger.Component


interface AppDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            AppDomainApiDiModule::class,
            NestedScopeComponentsDiModule::class,
        ]
    )
    @ApplicationScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun inject(activity: AppActivity)

        @Component.Factory
        interface Factory {
            fun create(
                dependencies: FactoryDependencies
            ): DiComponent
        }
    }


    interface FactoryDependencies {
        val appContext: Context
    }


    interface ApplicationScopeDependencies {
        /* no-op */
    }


    interface DiComponentInterface {
        val appDomainApi: AppDomainApi
    }
}



