package com.pedroabinajm.thebestburgers.di

import com.pedroabinajm.thebestburgers.view.hamburgers.HamburgersActivity
import com.pedroabinajm.thebestburgers.view.hamburgers.HamburgersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [HamburgersModule::class])
    abstract fun bindHamburgersActivity() : HamburgersActivity
}