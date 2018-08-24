package com.pedroabinajm.thebestburgers.rule

import android.app.Activity
import android.support.test.rule.ActivityTestRule

inline fun <reified T : Activity> activityRule(
    initialTouchMode: Boolean = false,
    launchActivity: Boolean = true
) = ActivityTestRule<T>(T::class.java, initialTouchMode, launchActivity)
