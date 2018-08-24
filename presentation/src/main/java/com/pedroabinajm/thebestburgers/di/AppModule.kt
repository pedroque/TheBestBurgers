package com.pedroabinajm.thebestburgers.di

import android.app.Application
import com.pedroabinajm.thebestburgers.TheBestBurgersApp
import com.pedroabinajm.thebestburgers.core.rx.SchedulerProvider
import com.pedroabinajm.thebestburgers.rx.DefaultSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(
        private val application: Application
) {

    @Provides
    @Singleton
    internal fun provideBaseApp() = application as TheBestBurgersApp

    @Provides
    @Singleton
    internal fun provideApplicationContext() = application.applicationContext

    @Provides
    internal fun provideSchedulerProvider(schedulerProvider: DefaultSchedulerProvider):
            SchedulerProvider = schedulerProvider

}