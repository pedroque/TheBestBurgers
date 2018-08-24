package com.pedroabinajm.thebestburgers.espresso

import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

fun withViewId(
        viewId: Int,
        then: ViewInteraction.() -> Unit
) = with(onView(withId(viewId))) {
    then()
}

fun withViewText(
        @StringRes text: Int,
        then: ViewInteraction.() -> Unit
) = with(onView(withText(text))) {
    then()
}

fun ViewInteraction.hasErrorText(
        errorText: String,
        then: ViewInteraction.() -> Unit = {}
) = check(matches(ViewMatchers.hasErrorText(errorText))).then()

fun ViewInteraction.hasErrorText(
        @StringRes errorText: Int,
        then: ViewInteraction.() -> Unit = {}
) = hasErrorText(getString(errorText), then)

fun ViewInteraction.typeText(
        text: String,
        then: ViewInteraction.() -> Unit = {}
) = perform(
        ViewActions.typeText(text),
        ViewActions.closeSoftKeyboard()
).then()

fun ViewInteraction.click(
        then: ViewInteraction.() -> Unit = {}
) = perform(ViewActions.click()).then()

fun getString(@StringRes resId: Int): String =
        InstrumentationRegistry.getTargetContext().getString(resId)
