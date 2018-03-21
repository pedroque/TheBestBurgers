package com.pedroabinajm.hamburgers.data.repository

import com.pedroabinajm.hamburgers.R
import com.pedroabinajm.hamburgers.data.exception.InvalidArgumentException
import com.pedroabinajm.hamburgers.data.repository.datasource.HamburgerDataSourceFactory
import com.pedroabinajm.hamburgers.domain.Hamburger
import com.pedroabinajm.hamburgers.domain.repository.HamburgerRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class HamburgerRepositoryImpl @Inject constructor(
        private val hamburgerDataSourceFactory: HamburgerDataSourceFactory
) : HamburgerRepository {
    override fun addHamburger(hamburger: Hamburger): Completable {
        if (hamburger.name.isBlank()) {
            return Completable.error(
                    InvalidArgumentException(R.string.error_hamburger_name_empty)
            )
        }
        if (hamburger.address.isBlank()) {
            return Completable.error(
                    InvalidArgumentException(R.string.error_hamburger_address_empty)
            )
        }
        if (hamburger.rating == 0f) {
            return Completable.error(
                    InvalidArgumentException(R.string.error_hamburger_rating_empty)
            )
        }
        return hamburgerDataSourceFactory.createLocalDataSource()
                .addHamburger(hamburger)
                .andThen(hamburgerDataSourceFactory.createRemoteDataSource()
                        .addHamburger(hamburger))
    }

    override fun getHamburgers(): Observable<List<Hamburger>> {
        return hamburgerDataSourceFactory.create().getHamburguers()
    }
}