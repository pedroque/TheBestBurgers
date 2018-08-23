package com.pedroabinajm.thebestburgers.di

import com.pedroabinajm.thebestburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.thebestburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerMapper
import com.pedroabinajm.thebestburgers.hamburgers.view.ViewModelFactory
import com.pedroabinajm.thebestburgers.hamburgers.data.repository.DefaultHamburgerRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
open class HamburgersModule {

    @Provides
    @Reusable
    internal fun provideHamburgerRepository(hamburgerRepository: DefaultHamburgerRepository)
            : HamburgerRepository = hamburgerRepository

    @Provides
    internal fun provideViewModelFactory(getHamburgers: GetHamburgers, hamburgerMapper: HamburgerMapper) =
            ViewModelFactory(getHamburgers, hamburgerMapper)

}