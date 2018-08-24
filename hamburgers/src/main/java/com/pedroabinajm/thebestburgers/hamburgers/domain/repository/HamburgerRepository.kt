package com.pedroabinajm.thebestburgers.hamburgers.domain.repository

import com.pedroabinajm.thebestburgers.hamburgers.domain.Hamburger
import io.reactivex.Completable
import io.reactivex.Single

interface HamburgerRepository {
    fun getHamburgers(): Single<List<Hamburger>>
    fun addHamburger(hamburger: Hamburger): Completable
}