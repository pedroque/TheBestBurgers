package com.pedroabinajm.thebestburgers.view.hamburgers

import com.pedroabinajm.thebestburgers.domain.Hamburger
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