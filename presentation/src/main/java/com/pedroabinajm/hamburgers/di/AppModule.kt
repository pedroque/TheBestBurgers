package com.pedroabinajm.hamburgers.di

import android.app.Application
import com.pedroabinajm.hamburgers.BaseApp
import com.pedroabinajm.hamburgers.domain.schedulers.SchedulerProvider
import com.pedroabinajm.hamburgers.schedulers.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(
        private val application: Application
) {

    @Provides
    @Singleton
    internal fun provideBaseApp() = application as BaseApp

    @Provides
    @Singleton
    internal fun provideApplicationContext() = application.applicationContext

    @Provides
    internal fun provideSchedulerProvider(schedulerProvider: SchedulerProviderImpl):
            SchedulerProvider = schedulerProvider

}