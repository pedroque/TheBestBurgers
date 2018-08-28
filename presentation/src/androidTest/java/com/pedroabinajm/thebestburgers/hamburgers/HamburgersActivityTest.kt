package com.pedroabinajm.thebestburgers.hamburgers

import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.pedroabinajm.thebestburgers.espresso.assert
import com.pedroabinajm.thebestburgers.espresso.idling.IsVisibleIdlingResource
import com.pedroabinajm.thebestburgers.espresso.matcher.atPosition
import com.pedroabinajm.thebestburgers.espresso.withViewId
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import com.pedroabinajm.thebestburgers.rule.activityRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HamburgersActivityTest {
    @Rule
    @JvmField
    val activityRule = activityRule<HamburgersActivity>()

    private var isBurgersRecyclerVisibleIdlingResource: IdlingResource? = null
    private val idlingRegistry = IdlingRegistry.getInstance()

    @Before
    fun setUp() {
        isBurgersRecyclerVisibleIdlingResource = IsVisibleIdlingResource(
                activityRule.activity.ui.recyclerView
        )
        idlingRegistry.register(isBurgersRecyclerVisibleIdlingResource)
    }

    @After
    fun tearDown() {
        idlingRegistry.unregister(isBurgersRecyclerVisibleIdlingResource)
    }


    @Test
    fun showHolyBurgerAt0() {
        withViewId(1) {
            assert {
                atPosition(0, hasDescendant(withText("Holy Burguer")))
            }
        }
    }

    @Test
    fun showButchersMarketAt1() {
        withViewId(1) {
            assert {
                atPosition(1, hasDescendant(withText("Butcher's Market")))
            }
        }
    }
}