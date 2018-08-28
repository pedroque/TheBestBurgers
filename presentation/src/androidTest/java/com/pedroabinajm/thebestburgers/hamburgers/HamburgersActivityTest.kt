package com.pedroabinajm.thebestburgers.hamburgers

import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.v7.widget.RecyclerView
import android.view.View
import com.pedroabinajm.thebestburgers.espresso.assert
import com.pedroabinajm.thebestburgers.espresso.idling.IsVisibleIdlingResource
import com.pedroabinajm.thebestburgers.espresso.withViewId
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import com.pedroabinajm.thebestburgers.rule.activityRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HamburgersActivityTest {
    @Rule
    @JvmField
    val activityRule = activityRule<HamburgersActivity>()

    private var isBurgersRecyclerVisibleIdlingResource: IdlingResource? = null

    @Before
    fun setUp() {
        isBurgersRecyclerVisibleIdlingResource = IsVisibleIdlingResource(
                activityRule.activity.ui.recyclerView
        )
        IdlingRegistry.getInstance().register(isBurgersRecyclerVisibleIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(isBurgersRecyclerVisibleIdlingResource)
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

fun atPosition(position: Int, viewMatcher: Matcher<View>) =
        object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("assert RecyclerView child at %d".format(position))
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                        ?: return false
                return viewMatcher.matches(viewHolder.itemView)
            }
        }
