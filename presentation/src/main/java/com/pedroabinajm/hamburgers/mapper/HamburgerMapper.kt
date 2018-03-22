package com.pedroabinajm.hamburgers.mapper

import com.pedroabinajm.hamburgers.model.HamburgerModel
import com.pedroabinajm.hamburgers.domain.Hamburger
import javax.inject.Inject

class HamburgerMapper @Inject constructor() {
    fun transform(hamburger: Hamburger): HamburgerModel {
        return HamburgerModel(
                hamburger.name,
                hamburger.rating,
                hamburger.address
        )
    }
}