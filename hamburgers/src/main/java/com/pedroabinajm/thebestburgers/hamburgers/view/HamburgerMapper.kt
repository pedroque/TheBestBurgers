package com.pedroabinajm.thebestburgers.hamburgers.view

import com.pedroabinajm.thebestburgers.hamburgers.domain.Hamburger
import javax.inject.Inject

class HamburgerMapper @Inject constructor() {
    fun transform(hamburger: Hamburger) = HamburgerModel(
            hamburger.name,
            hamburger.rating,
            hamburger.address
    )
}