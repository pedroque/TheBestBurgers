package com.pedroabinajm.hamburgers.domain.interactor

import com.pedroabinajm.hamburgers.domain.Hamburger
import com.pedroabinajm.hamburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.hamburgers.domain.schedulers.SchedulerProvider
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