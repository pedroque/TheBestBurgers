package com.pedroabinajm.thebestburgers.core.view.extension

import android.content.Context
import com.pedroabinajm.thebestburgers.core.R

fun defaultPadding(context: Context) = context.resources
        .getDimension(R.dimen.default_padding)
        .toInt()