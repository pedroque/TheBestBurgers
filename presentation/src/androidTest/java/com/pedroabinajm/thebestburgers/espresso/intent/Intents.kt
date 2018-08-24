package com.pedroabinajm.thebestburgers.espresso.intent

import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent

fun trackIntents(tracked: () -> Unit) {
    Intents.init()
    tracked()
    Intents.release()
}

inline fun <reified T> intendedComponent() = intended(hasComponent(T::class.java.name))
