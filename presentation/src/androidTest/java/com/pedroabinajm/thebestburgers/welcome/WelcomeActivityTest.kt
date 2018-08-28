package com.pedroabinajm.thebestburgers.welcome

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.espresso.assert
import com.pedroabinajm.thebestburgers.espresso.click
import com.pedroabinajm.thebestburgers.espresso.intent.intendedComponent
import com.pedroabinajm.thebestburgers.espresso.intent.intending
import com.pedroabinajm.thebestburgers.espresso.intent.trackIntents
import com.pedroabinajm.thebestburgers.espresso.withViewText
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerModel
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import com.pedroabinajm.thebestburgers.hamburgers.view.PICKED_HAMBURGER
import com.pedroabinajm.thebestburgers.rule.activityRule
import org.junit.Rule
import org.junit.Test

class WelcomeActivityTest {

    @Rule
    @JvmField
    val activityRule = activityRule<WelcomeActivity>()

    private val pickHamburgersResult = Instrumentation.ActivityResult(
            Activity.RESULT_OK,
            Intent().apply {
                putExtra(PICKED_HAMBURGER, HamburgerModel(
                        NAME,
                        RATING,
                        ADDRESS
                ))
            }
    )

    @Test
    fun checkTitleLabelIsVisible() {
        withViewText(R.string.welcome_title_text) {
            assert {
                isDisplayed()
            }
        }
    }

    @Test
    fun checkPickBurgersShowActivity() {
        trackIntents {
            withViewText(R.string.pick_favorite_burger) {
                click()
            }
            intendedComponent<HamburgersActivity>()
        }
    }

    @Test
    fun pickBurgerShowItsName() {
        trackIntents {
            intending<HamburgersActivity>().respondWith(pickHamburgersResult)

            withViewText(R.string.pick_favorite_burger) {
                click()
            }

            withViewText(NAME) {
                assert {
                    isDisplayed()
                }
            }
        }
    }
}

private const val NAME = "Bullger"
private const val RATING = 5F
private const val ADDRESS = "Shopping Eldorado"