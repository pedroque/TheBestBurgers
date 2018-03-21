package com.pedroabinajm.hamburgers.domain.repository

import com.pedroabinajm.hamburgers.domain.Hamburger
import io.reactivex.Completable
import io.reactivex.Observable

interface HamburgerRepository {
    fun getHamburgers() : Observable<List<Hamburger>>
    fun addHamburger(hamburger: Hamburger): Completable
}