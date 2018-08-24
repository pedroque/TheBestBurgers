package com.pedroabinajm.thebestburgers.hamburgers.domain.usecase

import com.pedroabinajm.thebestburgers.core.domain.UseCase
import com.pedroabinajm.thebestburgers.core.rx.SchedulerProvider
import com.pedroabinajm.thebestburgers.hamburgers.domain.Hamburger
import com.pedroabinajm.thebestburgers.hamburgers.domain.repository.HamburgerRepository
import javax.inject.Inject

class GetHamburgers @Inject constructor(
    private val hamburguerRepository: HamburgerRepository,
    schedulerProvider: SchedulerProvider
) : UseCase<List<Hamburger>>(schedulerProvider) {
    fun getHamburgers(
            onNext: ((List<Hamburger>) -> Unit),
            onError: ((Throwable) -> Unit)
    ) = execute(hamburguerRepository.getHamburgers().map { hamburgers ->
        hamburgers.sortedByDescending { hamburger ->
            hamburger.rating
        }
    }, onNext, onError)

}