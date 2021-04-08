package com.example.modularization.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modularization.app.R
import com.example.modularization.app.TheApp
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