package com.pedroabinajm.hamburgers

import android.app.Application
import dagger.android.HasActivityInjector
import android.app.Activity
import com.pedroabinajm.hamburgers.di.AppModule
import com.pedroabinajm.hamburgers.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class BaseApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .appModule(AppModule(this))
                .create(this)
                .inject(this)
    }

    override fun activityInjector() = activityDispatchingAndroidInjector
}