package com.pedroabinajm.thebestburgers.espresso.idling

import android.support.test.espresso.IdlingResource
import android.support.v4.app.FragmentManager

class DialogFragmentIdlingResource(
    private val manager: FragmentManager,
    private val tag: String
) : IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName() = "dialog fragment idling resource %d".format(hashCode())

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback
    }

    override fun isIdleNow(): Boolean {
        val idle = (manager.findFragmentByTag(tag) == null)
        if (idle) {
            resourceCallback?.onTransitionToIdle()
        }
        return idle
    }
}
