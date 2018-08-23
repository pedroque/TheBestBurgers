package com.pedroabinajm.thebestburgers.view.hamburgers

import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.view.base.BindingAdapter


class HamburgersAdapter : BindingAdapter<HamburgerModel>() {
    override fun getLayoutIdForPosition(position: Int) = R.layout.item_hamburger
}