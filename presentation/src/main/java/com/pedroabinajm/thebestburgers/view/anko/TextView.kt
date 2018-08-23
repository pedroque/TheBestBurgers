package com.pedroabinajm.thebestburgers.view.anko

import android.view.Gravity
import android.view.ViewManager
import android.widget.TextView
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.extensions.friendlyMessage
import com.pedroabinajm.thebestburgers.extensions.showIf
import com.pedroabinajm.thebestburgers.viewmodel.Resource
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