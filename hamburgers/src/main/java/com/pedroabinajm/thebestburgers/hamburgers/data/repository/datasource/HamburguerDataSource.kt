package com.pedroabinajm.thebestburgers.hamburgers.data.repository.datasource

import com.pedroabinajm.thebestburgers.hamburgers.domain.Hamburger
import io.reactivex.Completable
import io.reactivex.Single

interface HamburguerDataSource {
    fun getHamburguers(): Single<List<Hamburger>>
    fun addHamburger(hamburger: Hamburger): Completable
}