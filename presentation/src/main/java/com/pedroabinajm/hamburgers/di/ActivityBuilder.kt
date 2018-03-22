package com.pedroabinajm.hamburgers.di

import com.pedroabinajm.hamburgers.view.hamburgers.HamburgersActivity
import com.pedroabinajm.hamburgers.view.hamburgers.HamburgersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [HamburgersModule::class])
    abstract fun bindHamburgersActivity() : HamburgersActivity
}