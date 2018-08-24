package com.pedroabinajm.thebestburgers.di

import android.app.Application
import com.pedroabinajm.thebestburgers.TheBestBurgersApp
import com.pedroabinajm.thebestburgers.hamburgers.di.HamburgersActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    HamburgersActivityBuilder::class
])
interface AppComponent : AndroidInjector<TheBestBurgersApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TheBestBurgersApp>() {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract fun appModule(appModule: AppModule): Builder
    }
}