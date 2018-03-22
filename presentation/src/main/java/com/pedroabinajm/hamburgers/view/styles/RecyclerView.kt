package com.pedroabinajm.hamburgers.view.styles

import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import com.pedroabinajm.hamburgers.extensions.showIf
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.fixedSizeRecyclerView(layoutManager: RecyclerView.LayoutManager,
                                             resource: Resource<*>?,
                                             init: RecyclerView.() -> Unit = {}): RecyclerView {
    val recyclerView = fixedSizeRecyclerView(layoutManager, init)
    recyclerView.showIf {
        resource?.isEmpty?.equals(false) ?: false
    }
    return recyclerView
}

inline fun ViewManager.fixedSizeRecyclerView(layoutManager: RecyclerView.LayoutManager,
                                             init: RecyclerView.() -> Unit = {}): RecyclerView {
    val recyclerView = ankoView(::RecyclerView, 0, init)
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = layoutManager
    return recyclerView
}