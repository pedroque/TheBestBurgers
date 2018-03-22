package com.pedroabinajm.hamburgers.extensions

import com.pedroabinajm.hamburgers.R
import java.io.IOException

val Throwable.friendlyMessage: Int
    get() = when{
        this is IOException -> R.string.error_network
        else -> R.string.error_unexpected
    }