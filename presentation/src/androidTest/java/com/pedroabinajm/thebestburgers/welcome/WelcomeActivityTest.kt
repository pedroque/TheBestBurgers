package com.pedroabinajm.thebestburgers.welcome

import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.pedroabinajm.thebestburgers.R
import com.pedroabinajm.thebestburgers.espresso.withViewText
import com.pedroabinajm.thebestburgers.rule.activityRule
import org.junit.Rule
import org.junit.Test

class WelcomeActivityTest {

    @Rule
    @JvmField
    val activityRule = activityRule<WelcomeActivity>()

    @Test
    fun titleTextFilledIsVisible() {
        withViewText(R.string.welcome_title_text) {
            matches(isDisplayed())
        }
    }

}