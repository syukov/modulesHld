package com.example.modularization.main_feature.router.tabSwitcher

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.modularization.main_feature.screens.tabs.TabContainerFragment
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.main_feature_api.TabNames
import com.example.modularization.ui_core.mvp.IBaseView
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider


/**
 * Отвечает за переключение видимости TabContainerFragment-ов.
 */
open class TabSwitcherRouterNavigator(
    private val fragmentManager: FragmentManager,
    private val containerId: Int,
    private val catalogueTabFragmentProvider: Provider<TabContainerFragment>,
    private val cartTabFragmentProvider: Provider<TabContainerFragment>,
) : Navigator {

    class Factory @Inject constructor(
        @Named(TabNames.CATALOGUE) private val catalogueTabFragmentProvider: Provider<TabContainerFragment>,
        @Named(TabNames.CART) private val cartTabFragmentProvider: Provider<TabContainerFragment>,
    ) {
        fun create(
            fragmentManager: FragmentManager,
            containerId: Int,
        ) = TabSwitcherRouterNavigator(
            fragmentManager,
            containerId,
            catalogueTabFragmentProvider,
            cartTabFragmentProvider
        )
    }

    override fun applyCommands(vararg commands: Command) {
        if (commands.none { it is TabSwitcherRouterCommand }) return

        fragmentManager.executePendingTransactions()

        for (command in commands) {
            if (command is TabSwitcherRouterCommand) applyCommand(command)
        }
    }

    protected open fun applyCommand(command: TabSwitcherRouterCommand) {
        return when (command) {
            is TabSwitcherRouterCommand.Replace -> replace(command)
        }
    }

    protected open fun replace(command: TabSwitcherRouterCommand.Replace) {
        val currentFragment: TabContainerFragment? =
            fragmentManager.fragments.firstOrNull { it.isVisible } as? TabContainerFragment

        var newFragment: TabContainerFragment? =
            fragmentManager.findFragmentByTag(command.tab.tag) as? TabContainerFragment


        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return


        fragmentManager.beginTransaction().apply {

            currentFragment?.let { fragment ->
                hide(fragment)
                (fragment as? IBaseView)?.apply { onLeave() }
            }

            if (newFragment == null) {
                newFragment = when (command.tab) {
                    MainRouter.Tab.Catalogue -> catalogueTabFragmentProvider.get()
                    MainRouter.Tab.Cart -> cartTabFragmentProvider.get()
                }?.also { fragment ->
                    fragment.arguments = Bundle().also { it.putString("TabName", command.tab.tag) }
                    add(containerId, fragment, command.tab.tag)
                }
            }

            newFragment?.let { show(it) }
        }.commit()
    }
}