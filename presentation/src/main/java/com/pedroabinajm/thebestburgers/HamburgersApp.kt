package com.pedroabinajm.thebestburgers

import android.app.Activity
import android.app.Application
import com.pedroabinajm.thebestburgers.di.AppModule
import com.pedroabinajm.thebestburgers.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class HamburgersApp : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .create(this)
                .inject(this)
    }

    override fun activityInjector() = activityDispatchingAndroidInjector
}