package com.pedroabinajm.thebestburgers.espresso.idling

import android.support.test.espresso.IdlingResource
import android.view.View

class IsVisibleIdlingResource(
        private val view: View?
) : IdlingResource {
    private var callback: IdlingResource.ResourceCallback? = null

    override fun getName() = "is view visible idling resource %d".format(hashCode())

    override fun isIdleNow(): Boolean {
        val isIdle = view?.visibility == View.VISIBLE
        if (isIdle) {
            callback?.onTransitionToIdle()
        }
        return isIdle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        this.callback = callback
    }
}