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
    val activityRule = activityRule<WelcomeActivity>(launchActivity = false)

    private val pickedHamburgerMock = Intent().apply {
        putExtra(PICKED_HAMBURGER, HamburgerModel(
                PICKED_HAMBURGER_NAME,
                PICKED_HAMBURGER_RATING,
                PICKED_HAMBURGER_ADDRESS
        ))
    }

    @Test
    fun titleTextFilledIsVisible() {
        activityRule.launchActivity(null)
        withViewText(R.string.welcome_title_text) {
            assert {
                isDisplayed()
            }
        }
    }

    @Test
    fun clickPickBurgerButtonShowBurgers() {
        activityRule.launchActivity(null)
        trackIntents {
            withViewText(R.string.pick_favorite_burger) {
                click()
            }
            intendedComponent<HamburgersActivity>()
        }
    }

    @Test
    fun pickFavoriteBurgerShowBurgerName() {
        trackIntents {
            intending<HamburgersActivity>().respondWith(
                    Instrumentation.ActivityResult(Activity.RESULT_OK, pickedHamburgerMock)
            )
            activityRule.launchActivity(null)

            withViewText(R.string.pick_favorite_burger) {
                click()
            }

            withViewText(PICKED_HAMBURGER_NAME) {
                assert {
                    isDisplayed()
                }
            }
        }
    }
}

private const val PICKED_HAMBURGER_NAME = "Holy Burger"
private const val PICKED_HAMBURGER_RATING = 5F
private const val PICKED_HAMBURGER_ADDRESS = "R. Dr. Cesário Mota Júnior, 527"