package com.example.modularization.app_feature_impl.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modularization.app_feature_impl.R
import com.example.modularization.app_feature_impl.app.TheApp
import javax.inject.Inject

class AppActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: AppActivityFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        TheApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        supportFragmentManager.fragmentFactory = fragmentFactory

        val rootFragment = fragmentFactory.instantiate(this.classLoader, "")
        supportFragmentManager.beginTransaction()
            .replace(R.id.app_container, rootFragment)
            .commit()
    }
}