package com.pedroabinajm.hamburgers.data.exception

import android.support.annotation.StringRes

class InvalidArgumentException(
        @StringRes
        val errorMsg: Int
) : Exception()