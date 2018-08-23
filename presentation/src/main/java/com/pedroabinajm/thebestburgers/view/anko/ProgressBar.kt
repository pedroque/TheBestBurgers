package com.pedroabinajm.thebestburgers.view.anko

import android.view.ViewManager
import android.widget.ProgressBar
import com.pedroabinajm.thebestburgers.extensions.showIf
import com.pedroabinajm.thebestburgers.viewmodel.Resource
import org.jetbrains.anko.progressBar

fun ViewManager.progressBar(
        init: (ProgressBar).() -> Unit = {}
): ProgressBar {
    return progressBar {
        init()
    }
}

fun ProgressBar.setResource(resource: Resource<*>?) {
    showIf {
        resource?.status?.equals(Resource.Status.LOADING) ?: true
    }
}