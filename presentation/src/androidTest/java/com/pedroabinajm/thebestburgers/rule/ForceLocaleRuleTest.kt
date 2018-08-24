package com.pedroabinajm.thebestburgers.rule

import android.support.test.filters.MediumTest
import com.pedroabinajm.thebestburgers.rule.ForceLocaleRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.util.Locale

@MediumTest
class ForceLocaleRuleTest {

    @Rule
    @JvmField
    val localeTestRule = ForceLocaleRule(Locale.US)

    @Test
    fun forceUsLocale() {
        assertEquals(Locale.US, Locale.getDefault())
    }
}
