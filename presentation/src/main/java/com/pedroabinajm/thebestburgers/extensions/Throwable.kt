package com.pedroabinajm.thebestburgers.extensions

import com.pedroabinajm.thebestburgers.R
import java.io.IOException

val Throwable.friendlyMessage: Int
    get() = when{
        this is IOException -> R.string.error_network
        else -> R.string.error_unexpected
    }