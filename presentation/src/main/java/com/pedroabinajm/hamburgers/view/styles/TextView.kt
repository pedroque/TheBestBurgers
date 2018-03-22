package com.pedroabinajm.hamburgers.view.styles

import android.view.Gravity
import android.view.ViewManager
import android.widget.TextView
import com.pedroabinajm.hamburgers.R
import com.pedroabinajm.hamburgers.extensions.friendlyMessage
import com.pedroabinajm.hamburgers.extensions.showIf
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import org.jetbrains.anko.textView

fun ViewManager.errorText(resource: Resource<*>?): TextView {
    return textView {
        textSize = 16f
        gravity = Gravity.CENTER
        showIf {
            resource?.status?.equals(Resource.Status.ERROR) ?: false
        }
        setText(resource?.error?.friendlyMessage ?: R.string.error_unexpected)
    }
}