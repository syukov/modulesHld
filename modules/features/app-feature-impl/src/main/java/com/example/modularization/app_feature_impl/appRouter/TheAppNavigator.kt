package com.example.modularization.app_feature_impl.appRouter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.app_feature_impl.activity.AppActivity
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.TransactionInfo
import javax.inject.Inject

/**
 * Это форк класса AppNavigator из библиотеки Cicerone.
 * Разница в том что он умеет работать с нашими коммандами и ключами экранов.
 * Главная причина: необходимость использования [AppRouter.ScreenToNameMapper] для того что бы сосредоточить логику
 * определения компонента фрагмента и его инициации в одном месте (в фабрике).
 */
open class TheAppNavigator @Inject constructor(
    private val appRouterKeyResolver: AppRouter.ScreenToNameMapper,
) : Navigator {
    fun init(appActivity: AppActivity) {
        activity = appActivity
    }

    private lateinit var activity: AppActivity

    private val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    private val fragmentFactory: FragmentFactory
        get() = fragmentManager.fragmentFactory

    private val containerId: Int
        get() = activity.getContainerId()

    private val localStackCopy = mutableListOf<TransactionInfo>()

    override fun applyCommands(vararg commands: Command) {
        fragmentManager.executePendingTransactions()

        //copy stack before apply commands
        copyStackToLocal()

        for (command in commands) {
            if (command is AppRouter.Command) applyCommand(command)
        }
    }

    private fun copyStackToLocal() {
        localStackCopy.clear()
        for (i in 0 until fragmentManager.backStackEntryCount) {
            val str = fragmentManager.getBackStackEntryAt(i).name!!
            localStackCopy.add(TransactionInfo.fromString(str))
        }
    }

    /**
     * Perform transition described by the navigation command
     *
     * @param command the navigation command to apply
     */
    protected open fun applyCommand(command: AppRouter.Command) {
        return when (command) {
            is AppRouter.Command.Back -> back()
            is AppRouter.Command.BackTo -> backTo(command)
            is AppRouter.Command.Forward -> forward(command)
            is AppRouter.Command.Replace -> replace(command)
            is AppRouter.Command.ReplaceRoot -> applyCommands(*command.getCommands())
        }
    }

    protected open fun forward(command: AppRouter.Command.Forward) {
        val type = if (command.clearContainer) TransactionInfo.Type.REPLACE else TransactionInfo.Type.ADD
        commitNewFragmentScreen(command.screen, type, true)
    }

    protected open fun replace(command: AppRouter.Command.Replace) {
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
            activityBack()
        }
    }

    protected open fun activityBack() {
        activity.finish()
    }

    protected open fun commitNewFragmentScreen(
        screen: AppRouter.Screen,
        type: TransactionInfo.Type,
        addToBackStack: Boolean
    ) {
        val fragmentClassName = appRouterKeyResolver.getFragmentName(screen)

        val fragment = fragmentFactory.instantiate(activity.classLoader, fragmentClassName)

        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        setupFragmentTransaction(
            transaction,
            fragmentManager.findFragmentById(containerId),
            fragment
        )
        when (type) {
            TransactionInfo.Type.ADD -> transaction.add(containerId, fragment, screen::class.java.name)
            TransactionInfo.Type.REPLACE -> transaction.replace(containerId, fragment, screen::class.java.name)
        }
        if (addToBackStack) {
            val transactionInfo = TransactionInfo(screen::class.java.name, type)
            transaction.addToBackStack(transactionInfo.toString())
            localStackCopy.add(transactionInfo)
        }
        transaction.commit()
    }

    /**
     * Performs [BackTo] command transition
     */
    protected open fun backTo(command: AppRouter.Command.BackTo) {
        val screenKeyClassName = command.screen?.let { it::class.java.name }
        val index = localStackCopy.indexOfFirst { it.screenKey == screenKeyClassName }
        if (index != -1) {
            val forRemove = localStackCopy.subList(index, localStackCopy.size)
            fragmentManager.popBackStack(forRemove.first().toString(), 0)
            forRemove.clear()
        } else {
            backToRoot()
        }
    }

    private fun backToRoot() {
        localStackCopy.clear()
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    /**
     * Override this method to setup fragment transaction [FragmentTransaction].
     * For example: setCustomAnimations(...), addSharedElement(...) or setReorderingAllowed(...)
     *
     * @param fragmentTransaction fragment transaction
     * @param currentFragment     current fragment in container
     *                            (for [Replace] command it will be screen previous in new chain, NOT replaced screen)
     * @param nextFragment        next screen fragment
     */
    protected open fun setupFragmentTransaction(
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment?
    ) {
        // Do nothing by default
    }
}