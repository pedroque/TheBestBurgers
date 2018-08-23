package com.pedroabinajm.thebestburgers.view.anko

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.AnkoComponent

interface ActivityAnkoComponent<T : AppCompatActivity> : AnkoComponent<T> {
    var toolbar: Toolbar?
}