package com.pedroabinajm.thebestburgers.core.view.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pedroabinajm.thebestburgers.core.view.base.BaseActivity
import org.jetbrains.anko.setContentView

abstract class AnkoActivity<UI : ActivityAnkoComponent<out AppCompatActivity>> : BaseActivity() {
    abstract val ui: UI

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (ui as ActivityAnkoComponent<AppCompatActivity>).setUp()
    }

    private fun ActivityAnkoComponent<AppCompatActivity>.setUp() {
        setContentView(this@AnkoActivity)
        toolbar?.let {
            setSupportActionBar(it)
        }
    }
}