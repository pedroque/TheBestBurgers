package com.pedroabinajm.thebestburgers.domain.interactor

import com.pedroabinajm.thebestburgers.domain.Hamburger
import com.pedroabinajm.thebestburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.thebestburgers.domain.schedulers.SchedulerProvider
import io.reactivex.Completable
import javax.inject.Inject

class AddHamburger @Inject constructor(
        private val hamburguerRepository: HamburgerRepository,
        schedulerProvider: SchedulerProvider
) : UseCase<Void>(schedulerProvider) {
    fun addHamburger(hamburger: Hamburger,
                     onComplete: () -> Unit = {},
                     onError: (Throwable) -> Unit = {}): Completable {
        return execute(
                hamburguerRepository.addHamburger(hamburger),
                onComplete,
                onError
        )
    }
}