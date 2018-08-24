package com.pedroabinajm.thebestburgers.welcome

import android.app.Activity
import android.content.Intent
import com.pedroabinajm.thebestburgers.core.view.anko.AnkoActivity
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerModel
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import com.pedroabinajm.thebestburgers.hamburgers.view.PICKED_HAMBURGER

class WelcomeActivity : AnkoActivity<WelcomeLayout>() {
    override val ui = WelcomeLayout()

    fun onPickFavoriteBurgerClick() {
        startActivityForResult(
                Intent(this, HamburgersActivity::class.java),
                HAMBURGERS_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HAMBURGERS_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.getParcelableExtra<HamburgerModel>(PICKED_HAMBURGER)?.let { hamburgerModel ->
                ui.setFavoriteBurger(hamburgerModel)
            }
        }
    }
}

private const val HAMBURGERS_REQUEST_CODE = 1