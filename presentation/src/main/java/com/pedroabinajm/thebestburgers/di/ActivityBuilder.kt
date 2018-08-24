package com.pedroabinajm.thebestburgers.di

import com.pedroabinajm.thebestburgers.welcome.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindWelcomeActivity(): WelcomeActivity
}