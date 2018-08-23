package com.pedroabinajm.thebestburgers.view.hamburgers

import com.pedroabinajm.thebestburgers.data.repository.DefaultHamburgerRepository
import com.pedroabinajm.thebestburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.thebestburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.thebestburgers.viewmodel.ViewModelFactory
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