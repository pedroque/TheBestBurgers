package com.pedroabinajm.thebestburgers.domain.interactor

import com.pedroabinajm.thebestburgers.domain.Hamburger
import com.pedroabinajm.thebestburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.thebestburgers.domain.schedulers.SchedulerProvider
import javax.inject.Inject

class GetHamburgers @Inject constructor(
        private val hamburguerRepository: HamburgerRepository,
        schedulerProvider: SchedulerProvider
) : UseCase<List<Hamburger>>(schedulerProvider) {
    fun getHamburgers(
            onNext: ((List<Hamburger>) -> Unit),
            onError: ((Throwable) -> Unit)
    ) = execute(hamburguerRepository.getHamburgers(), onNext, onError)
}