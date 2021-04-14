package com.example.modularization.core_feature.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.modularization.core_feature.mvp.IBaseView
import com.example.modularization.core_feature_api.navigation.CiceroneScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.TransactionInfo

/**
 * Это форк класса AppNavigator из библиотеки Cicerone:
 *  - умеет работать с акрументами,
 *  - использует для создания фрагментов не фабрику а RouterFragmentCreator
 *  - перед сменой фрагмента вызывает onLeave() на текущем.
 *
 *  Важно: при пересоздании вью у фрагмента может быть пересоздан фрагмент менеджер, и у нового по какой то причине может быть
 *  не mHost=null (хотя FragmentFactory остается от прежнего инстанса нормально),
 *  то нужно пересоздавать навигатор у роутера в onResume перед тем как сетить его в NavigatorHolder
 */
class RouterNavigator(
    private val routerFragmentCreator: RouterFragmentCreator,
    private var fragmentManager: FragmentManager,
    private val containerId: Int
) : Navigator {

    private val localStackCopy = mutableListOf<TransactionInfo>()

    override fun applyCommands(vararg commands: Command) {
        if (commands.none { it is RouterCommand }) return

        fragmentManager.executePendingTransactions()
        copyStackToLocal()

        for (command in commands) {
            if (command is RouterCommand) applyCommand(command)
        }
    }

    private fun copyStackToLocal() {
        localStackCopy.clear()
        for (i in 0 until fragmentManager.backStackEntryCount) {
            val str = fragmentManager.getBackStackEntryAt(i).name!!
            localStackCopy.add(TransactionInfo.fromString(str))
        }
    }

    private fun applyCommand(command: RouterCommand) {
        return when (command) {
            is RouterCommand.Back -> back()
            is RouterCommand.BackTo -> backTo(command)
            is RouterCommand.Forward -> forward(command)
            is RouterCommand.Replace -> replace(command)
        }
    }

    private fun forward(command: RouterCommand.Forward) {
        val type = if (command.clearContainer) TransactionInfo.Type.REPLACE else TransactionInfo.Type.ADD
        commitNewFragmentScreen(command.screen, type, true, command.argument)
    }

    private fun replace(command: RouterCommand.Replace) {
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            val removed = localStackCopy.removeAt(localStackCopy.lastIndex)
            commitNewFragmentScreen(command.screen, removed.type, true, command.argument)
        } else {
            commitNewFragmentScreen(command.screen, TransactionInfo.Type.REPLACE, false, command.argument)
        }
    }

    private fun back() {
        if (localStackCopy.isNotEmpty()) {
            currentFragmentOnLeave()
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
        }
    }


    private fun commitNewFragmentScreen(
        screen: CiceroneScreen,
        type: TransactionInfo.Type,
        addToBackStack: Boolean,
        argument: com.example.modularization.core_feature_api.navigation.BaseArgument?
    ) {
        val nextFragment = routerFragmentCreator.getFragmentByScreen(screen)

        argument?.let { nextFragment.arguments = it.toBundle() }

        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        setupFragmentTransaction(
            transaction,
            fragmentManager.findFragmentById(containerId),
            nextFragment
        )
        when (type) {
            TransactionInfo.Type.ADD -> transaction.add(containerId, nextFragment, screen::class.java.name)
            TransactionInfo.Type.REPLACE -> transaction.replace(containerId, nextFragment, screen::class.java.name)
        }
        if (addToBackStack) {
            val transactionInfo = TransactionInfo(screen::class.java.name, type)
            transaction.addToBackStack(transactionInfo.toString())
            localStackCopy.add(transactionInfo)
        }

        currentFragmentOnLeave()
        transaction.commit()
    }

    private fun backTo(command: RouterCommand.BackTo) {
        if (command.screen == null) {
            backToRoot()
        } else {
            val screenClassName = command.screen::class.java.name
            val index = localStackCopy.indexOfFirst { it.screenKey == screenClassName }
            if (index != -1) {
                val forRemove = localStackCopy.subList(index, localStackCopy.size)
                currentFragmentOnLeave()
                fragmentManager.popBackStack(forRemove.first().toString(), 0)
                forRemove.clear()
            } else {
                backToRoot()
            }
        }
    }

    private fun backToRoot() {
        localStackCopy.clear()
        currentFragmentOnLeave()
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun setupFragmentTransaction(
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        // Do nothing by default
    }

    private fun currentFragmentOnLeave() {
        val currentFragment = fragmentManager.findFragmentById(containerId)
        (currentFragment as? IBaseView)?.onLeave()
    }
}