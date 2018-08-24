package com.pedroabinajm.thebestburgers.core.view.anko

import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import com.pedroabinajm.thebestburgers.core.view.extension.showIf
import com.pedroabinajm.thebestburgers.core.view.viewmodel.Resource
import org.jetbrains.anko.custom.ankoView


inline fun ViewManager.recyclerView(
        init: RecyclerView.() -> Unit = {}
): RecyclerView = with(ankoView(::RecyclerView, 0, init)) {
    setHasFixedSize(true)
    this
}

fun RecyclerView.setResource(resource: Resource<*>?) = showIf {
    resource?.isEmpty?.equals(false) ?: false
}