package com.example.modularization.app_feature_impl.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.app_feature_impl.R
import com.example.modularization.app_feature_impl.app.TheApp
import com.example.modularization.app_feature_impl.appRouter.TheAppNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class AppActivity : AppCompatActivity() {

    @Inject
    lateinit var appRouter: AppRouter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var appRouterKeyResolver: AppRouter.ScreenToNameMapper

    @Inject
    lateinit var navigator: TheAppNavigator

    @Inject
    lateinit var appContainerFragmentFactory: AppContainerFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        TheApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.fragmentFactory = appContainerFragmentFactory
        navigator.init(this)
        appRouter.navigate(AppRouter.Command.Replace(AppRouter.Screen.EmployeeAuthFeature.Login))

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    fun getContainerId(): Int {
        return R.id.app_container
    }
}