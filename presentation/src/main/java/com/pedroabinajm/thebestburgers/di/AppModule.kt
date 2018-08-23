package com.pedroabinajm.thebestburgers.di

import android.app.Application
import com.pedroabinajm.thebestburgers.HamburgersApp
import com.pedroabinajm.thebestburgers.domain.schedulers.SchedulerProvider
import com.pedroabinajm.thebestburgers.schedulers.DefaultSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(
        private val application: Application
) {

    @Provides
    @Singleton
    internal fun provideBaseApp() = application as HamburgersApp

    @Provides
    @Singleton
    internal fun provideApplicationContext() = application.applicationContext

    @Provides
    internal fun provideSchedulerProvider(schedulerProvider: DefaultSchedulerProvider):
            SchedulerProvider = schedulerProvider

}