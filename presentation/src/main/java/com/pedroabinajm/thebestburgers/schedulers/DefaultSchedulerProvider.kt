package com.pedroabinajm.thebestburgers.schedulers

import com.pedroabinajm.thebestburgers.domain.schedulers.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun io() = Schedulers.computation()

    override fun ui() = AndroidSchedulers.mainThread()!!
}