package com.example.modularization.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.network_domain.di.DaggerNetworkDomainDi_DiComponent
import com.example.modularization.network_domain.di.NetworkDomainDi
import com.example.modularization.root_feature.di.DaggerRootFeatureDi_DiComponent
import com.example.modularization.root_feature.di.RootFeatureDi
import com.example.modularization.security_domain.di.DaggerSecurityDomainDi_DiComponent
import com.example.modularization.security_domain.di.SecurityDomainDi
import dagger.Module
import dagger.Provides


@Module
@DiDoc.NestedScopeComponentsDiModule
class NestedScopeComponentsDiModule {
    // Root Feature Module ---------------------------------------------------------------------------------------------
    @Provides
    @ApplicationScope
    fun provideComponent(
    ): RootFeatureDi.DiComponent {
        return DaggerRootFeatureDi_DiComponent.factory().create(
            object : RootFeatureDi.FactoryDependencies {}
        )
    }

    // All Domain Modules ----------------------------------------------------------------------------------------------

    @Provides
    @ApplicationScope
    fun networkDomainComponent(
    ): NetworkDomainDi.DiComponent {
        return DaggerNetworkDomainDi_DiComponent.factory().create(
            object : NetworkDomainDi.FactoryDependencies {
            }
        )
    }

    @Provides
    @ApplicationScope
    fun provideSecurityDomainComponent(
    ): SecurityDomainDi.DiComponent {
        return DaggerSecurityDomainDi_DiComponent.factory().create(
            object : SecurityDomainDi.FactoryDependencies {
            }
        )
    }

}