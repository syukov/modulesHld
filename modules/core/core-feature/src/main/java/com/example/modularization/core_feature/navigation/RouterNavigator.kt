package com.example.modularization.core_feature.navigation

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.modularization.core_feature.mvp.IBaseView
import com.example.modularization.core_feature_api.navigation.BaseArgument
import com.example.modularization.core_feature_api.navigation.CiceroneScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator

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

    private val localStackCopy = mutableListOf<String>()
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun applyCommands(vararg commands: Command) {
        mainHandler.post { applyCommandsSync(*commands) }
    }

    private fun applyCommandsSync(vararg commands: Command) {
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
            localStackCopy.add(fragmentManager.getBackStackEntryAt(i).name.orEmpty())
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
        commitNewFragmentScreen(command.screen, true, command.argument)
    }

    private fun replace(command: RouterCommand.Replace) {
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
            commitNewFragmentScreen(command.screen, true, command.argument)
        } else {
            commitNewFragmentScreen(command.screen, false, command.argument)
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
        addToBackStack: Boolean,
        argument: BaseArgument?
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
        transaction.replace(containerId, nextFragment, screen::class.java.name)
        if (addToBackStack) {
            transaction.addToBackStack(screen.screenKey)
            localStackCopy.add(screen.screenKey)
        }

        currentFragmentOnLeave()
        transaction.commit()
    }

    private fun backTo(command: RouterCommand.BackTo) {
        if (command.screen == null) {
            backToRoot()
        } else {
            val screenClassName = command.screen::class.java.name
            val index = localStackCopy.indexOfFirst { it == screenClassName }
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