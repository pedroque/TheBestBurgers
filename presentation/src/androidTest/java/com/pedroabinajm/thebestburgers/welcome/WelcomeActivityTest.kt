package com.pedroabinajm.thebestburgers.welcome

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgerModel
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import com.pedroabinajm.thebestburgers.hamburgers.view.PICKED_HAMBURGER
import org.junit.Rule
import org.junit.Test

class WelcomeActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<WelcomeActivity>(WelcomeActivity::class.java)

    @Test
    fun checkTitleLabelIsVisible() {
        onView(withText(R.string.welcome_title_text))
                .check(matches(isDisplayed()))
    }

    @Test
    fun checkPickBurgersShowActivity() {
        Intents.init()
        onView(withText(R.string.pick_favorite_burger))
                .perform(click())

        Intents.intended(IntentMatchers.hasComponent(HamburgersActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun pickBurgerShowItsName() {
        Intents.init()
        Intents.intending(IntentMatchers.hasComponent(HamburgersActivity::class.java.name))
                .respondWith(Instrumentation.ActivityResult(
                        Activity.RESULT_OK,
                        Intent().apply {
                            putExtra(PICKED_HAMBURGER, HamburgerModel(
                                    NAME,
                                    RATING,
                                    ADDRESS
                            ))
                        }
                ))

        onView(withText(R.string.pick_favorite_burger))
                .perform(click())

        onView(withText(NAME)).check(matches(isDisplayed()))
        Intents.release()
    }
}

private const val NAME = "Bullger"
private const val RATING = 5F
private const val ADDRESS = "Shopping Eldorado"