package com.pedroabinajm.thebestburgers.core.extensions

import android.content.Context
import com.pedroabinajm.thebestburgers.core.R

fun defaultPadding(context: Context) = context.resources
        .getDimension(R.dimen.default_padding)
        .toInt()