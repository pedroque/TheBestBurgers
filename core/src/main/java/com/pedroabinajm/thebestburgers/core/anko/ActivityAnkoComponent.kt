package com.pedroabinajm.thebestburgers.core.anko

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.AnkoComponent

interface ActivityAnkoComponent<T : AppCompatActivity> : AnkoComponent<T> {
    var toolbar: Toolbar?
}