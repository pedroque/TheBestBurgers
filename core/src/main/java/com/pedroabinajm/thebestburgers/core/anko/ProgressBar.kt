package com.pedroabinajm.thebestburgers.core.anko

import android.view.ViewManager
import android.widget.ProgressBar
import com.pedroabinajm.thebestburgers.core.viewmodel.Resource
import com.pedroabinajm.thebestburgers.core.extensions.showIf
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