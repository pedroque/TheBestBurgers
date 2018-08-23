package com.pedroabinajm.thebestburgers.domain.repository

import com.pedroabinajm.thebestburgers.domain.Hamburger
import io.reactivex.Completable
import io.reactivex.Single

interface HamburgerRepository {
    fun getHamburgers(): Single<List<Hamburger>>
    fun addHamburger(hamburger: Hamburger): Completable
}