package com.pedroabinajm.thebestburgers.welcome

import android.content.Intent
import com.pedroabinajm.thebestburgers.core.anko.AnkoActivity
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity

class WelcomeActivity : AnkoActivity<WelcomeLayout>() {
    override val ui = WelcomeLayout()

    fun onShowBurgersClick() {
        startActivity(Intent(this, HamburgersActivity::class.java))
    }
}