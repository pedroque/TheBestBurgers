package com.pedroabinajm.hamburgers.schedulers

import com.pedroabinajm.hamburgers.domain.schedulers.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    override fun io() = Schedulers.computation()

    override fun ui() = AndroidSchedulers.mainThread()!!
}