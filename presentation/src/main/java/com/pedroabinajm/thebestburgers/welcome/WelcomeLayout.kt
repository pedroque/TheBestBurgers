package com.pedroabinajm.thebestburgers.welcome

import android.support.v7.widget.Toolbar
import android.view.Gravity
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.core.anko.ActivityAnkoComponent
import com.pedroabinajm.thebestburgers.core.anko.bodyText
import com.pedroabinajm.thebestburgers.core.anko.titleText
import com.pedroabinajm.thebestburgers.core.extensions.defaultPadding
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.button
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class WelcomeLayout : ActivityAnkoComponent<WelcomeActivity> {
    override var toolbar: Toolbar? = null

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
                button(R.string.show_burgers) {
                    setOnClickListener {
                        ui.owner.onShowBurgersClick()
                    }
                }.lparams(wrapContent, wrapContent)
            }
        }
    }
}