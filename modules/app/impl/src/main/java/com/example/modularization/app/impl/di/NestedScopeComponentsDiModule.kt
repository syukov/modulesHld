package com.example.modularization.app.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.cart_domain.di.CartDomainDi
import com.example.modularization.cart_domain.di.DaggerCartDomainDi_DiComponent
import com.example.modularization.domain.core.impl.di.CoreDomainDi
import com.example.modularization.domain.core.impl.di.DaggerCoreDomainDi_DiComponent
import com.example.modularization.network_domain.di.DaggerNetworkDomainDi_DiComponent
import com.example.modularization.network_domain.di.NetworkDomainDi
import com.example.modularization.root_feature.di.DaggerRootFeatureDi_DiComponent
import com.example.modularization.root_feature.di.RootFeatureDi
import com.example.modularization.security_domain.di.DaggerSecurityDomainDi_DiComponent
import com.example.modularization.security_domain.di.SecurityDomainDi
import dagger.Module
import dagger.Provides


@Module
@Doc.NestedScopeComponentsDiModule
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
    fun coreDomainComponent(
    ): CoreDomainDi.DiComponent {
        return DaggerCoreDomainDi_DiComponent.factory().create(
            object : CoreDomainDi.FactoryDependencies {
            }
        )
    }

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

    @Provides
    @ApplicationScope
    fun provideCartDomainComponent(
    ): CartDomainDi.DiComponent {
        return DaggerCartDomainDi_DiComponent.factory().create(
            object : CartDomainDi.FactoryDependencies {
            }
        )
    }
}