package com.pedroabinajm.thebestburgers.runner

import android.support.test.runner.AndroidJUnitRunner
import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.plugins.RxJavaPlugins

class BurgersTestRunner : AndroidJUnitRunner() {
    override fun onStart() {
        RxJavaPlugins.setInitIoSchedulerHandler(
                Rx2Idler.create("RxJava 2.x IO Scheduler")
        )
        super.onStart()
    }
}