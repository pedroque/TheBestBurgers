package com.pedroabinajm.thebestburgers.hamburgers.di

import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HamburgersActivityBuilder {
    @ContributesAndroidInjector(modules = [HamburgersModule::class])
    abstract fun bindHamburgersActivity(): HamburgersActivity
}