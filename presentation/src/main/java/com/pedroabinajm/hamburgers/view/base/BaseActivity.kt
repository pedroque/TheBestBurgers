package com.pedroabinajm.hamburgers.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.pedroabinajm.hamburgers.di.Injectable
import com.pedroabinajm.hamburgers.view.anko.ActivityAnkoComponent
import dagger.android.AndroidInjection
import org.jetbrains.anko.setContentView

abstract class BaseActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>>
    : AppCompatActivity(), Injectable {

    abstract val ui: UI

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        (ui as ActivityAnkoComponent<AppCompatActivity>).setContentView(this)
        ui.toolbar?.let {
            setSupportActionBar(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}