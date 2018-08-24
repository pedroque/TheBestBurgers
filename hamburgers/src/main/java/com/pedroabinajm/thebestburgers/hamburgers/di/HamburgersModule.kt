package com.pedroabinajm.thebestburgers.hamburgers.di

import com.pedroabinajm.thebestburgers.hamburgers.data.repository.DefaultHamburgerRepository
import com.pedroabinajm.thebestburgers.hamburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.thebestburgers.hamburgers.domain.usecase.GetHamburgers
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerMapper
import com.pedroabinajm.thebestburgers.hamburgers.view.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
open class HamburgersModule {
    @Provides
    @Reusable
    fun provideHamburgerRepository(hamburgerRepository: DefaultHamburgerRepository)
            : HamburgerRepository = hamburgerRepository

    @Provides
    fun provideViewModelFactory(getHamburgers: GetHamburgers, hamburgerMapper: HamburgerMapper) =
            ViewModelFactory(getHamburgers, hamburgerMapper)

}