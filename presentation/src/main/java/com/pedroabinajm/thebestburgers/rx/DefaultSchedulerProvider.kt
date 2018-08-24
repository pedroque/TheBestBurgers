package com.pedroabinajm.thebestburgers.rx

import com.pedroabinajm.thebestburgers.core.rx.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun io() = Schedulers.computation()

    override fun ui() = AndroidSchedulers.mainThread()!!
}