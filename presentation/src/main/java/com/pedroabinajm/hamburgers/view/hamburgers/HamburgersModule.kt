package com.pedroabinajm.hamburgers.view.hamburgers

import com.pedroabinajm.hamburgers.data.repository.HamburgerRepositoryImpl
import com.pedroabinajm.hamburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.hamburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.hamburgers.mapper.HamburgerMapper
import com.pedroabinajm.hamburgers.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
open class HamburgersModule {

    @Provides
    @Reusable
    internal fun provideHamburgerRepository(hamburgerRepository: HamburgerRepositoryImpl)
            : HamburgerRepository = hamburgerRepository

    @Provides
    internal fun provideViewModelFactory(getHamburgers: GetHamburgers, hamburgerMapper: HamburgerMapper) =
            ViewModelFactory(getHamburgers, hamburgerMapper)

}