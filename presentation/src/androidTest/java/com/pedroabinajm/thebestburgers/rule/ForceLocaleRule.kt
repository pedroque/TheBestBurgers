package com.pedroabinajm.thebestburgers.rule

import android.os.LocaleList
import android.support.test.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.Locale

class ForceLocaleRule(private val testLocale: Locale) : TestRule {
    private var deviceLocale: Locale? = null

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    deviceLocale = Locale.getDefault()
                    setLocale(testLocale)

                    base.evaluate()
                } finally {
                    deviceLocale?.let {
                        setLocale(it)
                    }
                }
            }
        }
    }

    fun setLocale(locale: Locale) {
        val resources = InstrumentationRegistry.getTargetContext().resources
        Locale.setDefault(locale)
        val config = resources.configuration
        config.locales = LocaleList(locale)
        InstrumentationRegistry.getTargetContext().createConfigurationContext(config)
    }
}
