package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.modularization.root_feature_data.RootRouter
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.TransactionInfo
import javax.inject.Inject

/**
 * Это форк класса AppNavigator из библиотеки Cicerone.
 * Разница в том что он умеет работать с нашими коммандами и ключами экранов, а так же использует для создания
 * фрагментов не фабрику а RouterFragmentResolver
 */
open class RootRouterNavigator(
    private val rootRouterFragmentResolver: RootRouterFragmentResolver,
    private val fragment: Fragment,
    private val containerId: Int
) : Navigator {

    class Factory @Inject constructor(
        private val rootRouterFragmentResolver: RootRouterFragmentResolver,
    ) {
        fun create(fragment: Fragment, containerId: Int) = RootRouterNavigator(
            rootRouterFragmentResolver = rootRouterFragmentResolver,
            fragment = fragment,
            containerId = containerId
        )
    }

    private val fragmentManager: FragmentManager = fragment.childFragmentManager

    private val localStackCopy = mutableListOf<TransactionInfo>()

    override fun applyCommands(vararg commands: Command) {
        if (commands.none { it is RootRouterCommand }) return

        fragmentManager.executePendingTransactions()
        copyStackToLocal()

        for (command in commands) {
            if (command is RootRouterCommand) applyCommand(command)
        }
    }

    private fun copyStackToLocal() {
        localStackCopy.clear()
        for (i in 0 until fragmentManager.backStackEntryCount) {
            val str = fragmentManager.getBackStackEntryAt(i).name!!
            localStackCopy.add(TransactionInfo.fromString(str))
        }
    }

    protected open fun applyCommand(command: RootRouterCommand) {
        return when (command) {
            is RootRouterCommand.Back -> back()
            is RootRouterCommand.BackTo -> backTo(command)
            is RootRouterCommand.Forward -> forward(command)
            is RootRouterCommand.Replace -> replace(command)
        }
    }

    protected open fun forward(command: RootRouterCommand.Forward) {
        val type = if (command.clearContainer) TransactionInfo.Type.REPLACE else TransactionInfo.Type.ADD
        commitNewFragmentScreen(command.screen, type, true)
    }

    protected open fun replace(command: RootRouterCommand.Replace) {
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            val removed = localStackCopy.removeAt(localStackCopy.lastIndex)
            commitNewFragmentScreen(command.screen, removed.type, true)
        } else {
            commitNewFragmentScreen(command.screen, TransactionInfo.Type.REPLACE, false)
        }
    }

    protected open fun back() {
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
        } else {
//            fragment.activity.finish()
//            TODO()
        }
    }


    protected open fun commitNewFragmentScreen(
        screen: RootRouter.Screen,
        type: TransactionInfo.Type,
        addToBackStack: Boolean
    ) {
        val childFragment = rootRouterFragmentResolver.getFragmentByScreen(screen)
        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        setupFragmentTransaction(
            transaction,
            fragmentManager.findFragmentById(containerId),
            childFragment
        )
        when (type) {
            TransactionInfo.Type.ADD -> transaction.add(containerId, childFragment, screen::class.java.name)
            TransactionInfo.Type.REPLACE -> transaction.replace(containerId, childFragment, screen::class.java.name)
        }
        if (addToBackStack) {
            val transactionInfo = TransactionInfo(screen::class.java.name, type)
            transaction.addToBackStack(transactionInfo.toString())
            localStackCopy.add(transactionInfo)
        }
        transaction.commit()
    }

    protected open fun backTo(command: RootRouterCommand.BackTo) {
        if (command.screen == null) {
            backToRoot()
        } else {
            val screenClassName = command.screen::class.java.name
            val index = localStackCopy.indexOfFirst { it.screenKey == screenClassName }
            if (index != -1) {
                val forRemove = localStackCopy.subList(index, localStackCopy.size)
                fragmentManager.popBackStack(forRemove.first().toString(), 0)
                forRemove.clear()
            } else {
                backToRoot()
            }
        }
    }

    private fun backToRoot() {
        localStackCopy.clear()
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    protected open fun setupFragmentTransaction(
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment?
    ) {
        // Do nothing by default
    }
}