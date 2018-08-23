package com.pedroabinajm.thebestburgers.di

import android.app.Application
import com.pedroabinajm.thebestburgers.HamburgersApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class
])
interface AppComponent : AndroidInjector<HamburgersApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HamburgersApp>() {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract fun appModule(appModule: AppModule): Builder
    }
}