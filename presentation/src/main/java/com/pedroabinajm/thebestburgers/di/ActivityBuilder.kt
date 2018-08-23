package com.pedroabinajm.thebestburgers.di

import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [HamburgersModule::class])
    abstract fun bindHamburgersActivity(): HamburgersActivity
}