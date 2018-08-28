package com.pedroabinajm.thebestburgers.hamburgers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.view.View
import com.pedroabinajm.thebestburgers.espresso.idling.IsVisibleIdlingResource
import com.pedroabinajm.thebestburgers.hamburgers.view.HamburgersActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class HamburgersActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule<HamburgersActivity>(HamburgersActivity::class.java)

    @Test
    fun showHolyBurgerAt0() {
        val idlingResource = IsVisibleIdlingResource(
                activityRule.activity.ui.recyclerView
        )
        IdlingRegistry.getInstance().register(idlingResource)
        onView(ViewMatchers.withId(1))
                .check(matches(
                        atPosition(
                                0,
                                hasDescendant(withText("Holy Burguer"))
                        )
                ))
        IdlingRegistry.getInstance().unregister(idlingResource)
    }

    @Test
    fun showHolyBurgerAt1() {
        val idlingResource = IsVisibleIdlingResource(
                activityRule.activity.ui.recyclerView
        )
        IdlingRegistry.getInstance().register(idlingResource)
        onView(ViewMatchers.withId(1))
                .check(matches(
                        atPosition(
                                1,
                                hasDescendant(withText("Butcher's Market"))
                        )
                ))
        IdlingRegistry.getInstance().unregister(idlingResource)
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
