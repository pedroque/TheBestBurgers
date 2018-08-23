package com.pedroabinajm.thebestburgers.core.extensions

import com.pedroabinajm.thebestburgers.core.R
import java.io.IOException

val Throwable.friendlyMessage: Int
    get() = when {
        this is IOException -> R.string.error_network
        else -> R.string.error_unexpected
    }