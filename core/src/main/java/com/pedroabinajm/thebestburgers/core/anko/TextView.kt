package com.pedroabinajm.thebestburgers.core.anko

import android.graphics.Color
import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.Gravity
import android.view.ViewManager
import android.widget.TextView
import com.pedroabinajm.thebestburgers.core.R
import com.pedroabinajm.thebestburgers.core.extensions.friendlyMessage
import com.pedroabinajm.thebestburgers.core.extensions.showIf
import com.pedroabinajm.thebestburgers.core.viewmodel.Resource
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView

typealias ErrorTextView = TextView

fun ViewManager.errorText(
        init: (ErrorTextView).() -> Unit = {}
): ErrorTextView = textView {
    textSize = 16F
    gravity = Gravity.CENTER
    init()
}

fun ErrorTextView.setResource(resource: Resource<*>?) {
    showIf {
        resource?.status?.equals(Resource.Status.ERROR) ?: false
    }
    setText(resource?.error?.friendlyMessage ?: R.string.error_unexpected)
}

fun ViewManager.titleText(
        @StringRes text: Int = 0,
        init: (TextView).() -> Unit = {}
): TextView = textView(text) {
    textSize = 20F
    maxLines = 1
    ellipsize = TextUtils.TruncateAt.END
    textColor = Color.WHITE
    init()
}

fun ViewManager.bodyText(
        @StringRes text: Int = 0,
        init: (TextView).() -> Unit = {}
): TextView = textView(text) {
    textSize = 14F
    init()
}