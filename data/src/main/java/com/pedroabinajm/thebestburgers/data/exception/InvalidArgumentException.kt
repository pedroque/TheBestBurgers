package com.pedroabinajm.thebestburgers.data.exception

import android.support.annotation.StringRes

class InvalidArgumentException(
        @StringRes
        val errorMsg: Int
) : Exception()