package com.pedroabinajm.hamburgers.domain.schedulers

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io() : Scheduler
    fun ui() : Scheduler
}