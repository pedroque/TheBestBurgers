package com.pedroabinajm.hamburgers.domain.interactor

import com.pedroabinajm.hamburgers.domain.Hamburger
import com.pedroabinajm.hamburgers.domain.repository.HamburgerRepository
import com.pedroabinajm.hamburgers.domain.schedulers.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class GetHamburgers @Inject constructor(
        private val hamburguerRepository: HamburgerRepository,
        schedulerProvider: SchedulerProvider
) : UseCase<List<Hamburger>>(schedulerProvider) {
    fun getHamburgers(onNext: ((List<Hamburger>) -> Unit), onError: ((Throwable) -> Unit)) : Observable<List<Hamburger>>{
        return execute(hamburguerRepository.getHamburgers(), onNext, onError)
    }
}