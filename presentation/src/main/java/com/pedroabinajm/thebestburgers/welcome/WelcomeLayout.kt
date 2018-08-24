package com.pedroabinajm.thebestburgers.welcome

import android.graphics.Color
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.TextView
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.core.view.anko.ActivityAnkoComponent
import com.pedroabinajm.thebestburgers.core.view.anko.bodyText
import com.pedroabinajm.thebestburgers.core.view.anko.titleText
import com.pedroabinajm.thebestburgers.core.view.extension.defaultPadding
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerModel
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.button
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class WelcomeLayout : ActivityAnkoComponent<WelcomeActivity> {
    override var toolbar: Toolbar? = null
    private var favoriteBurgerText: TextView? = null

    override fun createView(ui: AnkoContext<WelcomeActivity>) = with(ui) {
        verticalLayout {
            toolbar = toolbar {
                lparams(width = matchParent)
            }

            verticalLayout {
                lparams(matchParent, matchParent)
                gravity = Gravity.CENTER
                padding = defaultPadding(context)

                titleText(R.string.welcome_title_text) {
                    gravity = Gravity.CENTER
                    lparams {
                        bottomMargin = defaultPadding(context)
                    }
                }
                bodyText(R.string.welcome_body_text) {
                    gravity = Gravity.CENTER
                    lparams {
                        bottomMargin = defaultPadding(context)
                    }
                }
                button(R.string.pick_favorite_burger) {
                    setOnClickListener {
                        ui.owner.onPickFavoriteBurgerClick()
                    }
                }.lparams(wrapContent, wrapContent) {
                    bottomMargin = defaultPadding(context)
                }
                favoriteBurgerText = bodyText(R.string.favorite_burger_hint) {
                    gravity = Gravity.CENTER
                    textColor = Color.WHITE
                }
            }
        }
    }

    fun setFavoriteBurger(hamburger: HamburgerModel) {
        favoriteBurgerText?.text = hamburger.name
    }
}