package com.pedroabinajm.thebestburgers.core.anko

import android.view.Gravity
import android.view.ViewManager
import android.widget.TextView
import com.pedroabinajm.thebestburgers.core.R
import com.pedroabinajm.thebestburgers.core.extensions.friendlyMessage
import com.pedroabinajm.thebestburgers.core.extensions.showIf
import com.pedroabinajm.thebestburgers.core.viewmodel.Resource
import org.jetbrains.anko.textView

typealias ErrorTextView = TextView

fun ViewManager.errorText(
        init: (ErrorTextView).() -> Unit = {}
): ErrorTextView {
    return textView {
        textSize = 16f
        gravity = Gravity.CENTER
        init()
    }
}

fun ErrorTextView.setResource(resource: Resource<*>?) {
    showIf {
        resource?.status?.equals(Resource.Status.ERROR) ?: false
    }
    setText(resource?.error?.friendlyMessage ?: R.string.error_unexpected)
}