package com.pedroabinajm.hamburgers.data.repository.datasource

import com.pedroabinajm.hamburgers.domain.Hamburger
import io.reactivex.Completable
import io.reactivex.Observable

interface HamburguerDataSource {
    fun getHamburguers() : Observable<List<Hamburger>>
    fun addHamburger(hamburger: Hamburger): Completable
}