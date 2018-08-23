package com.pedroabinajm.thebestburgers.hamburgers.data.repository.datasource

import javax.inject.Inject

class HamburgerDataSourceFactory @Inject constructor() {
    fun create(): HamburguerDataSource {
        return createRemoteDataSource()
    }

    fun createLocalDataSource(): HamburguerDataSource {
        return LocalHamburguersDataSource()
    }

    fun createRemoteDataSource(): HamburguerDataSource {
        return RemoteHamburguersDataSource()
    }
}