package com.pedroabinajm.thebestburgers.hamburgers.view

import com.pedroabinajm.thebestburgers.domain.Hamburger
import javax.inject.Inject

class HamburgerMapper @Inject constructor() {
    fun transform(hamburger: Hamburger) = HamburgerModel(
            hamburger.name,
            hamburger.rating,
            hamburger.address
    )
}