package com.pedroabinajm.hamburgers.view.styles

import android.view.ViewManager
import android.widget.ProgressBar
import com.pedroabinajm.hamburgers.extensions.showIf
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import org.jetbrains.anko.progressBar

fun ViewManager.progressBar(resource: Resource<*>?): ProgressBar {
    return progressBar {
        showIf {
            resource?.status?.equals(Resource.Status.LOADING) ?: true
        }
    }
}