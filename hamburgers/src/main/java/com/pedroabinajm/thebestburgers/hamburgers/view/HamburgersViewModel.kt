package com.pedroabinajm.thebestburgers.hamburgers.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroabinajm.thebestburgers.core.view.viewmodel.Resource
import com.pedroabinajm.thebestburgers.core.view.viewmodel.resourceCompleted
import com.pedroabinajm.thebestburgers.core.view.viewmodel.resourceError
import com.pedroabinajm.thebestburgers.core.view.viewmodel.resourceLoading
import com.pedroabinajm.thebestburgers.core.view.viewmodel.resourceSuccess
import com.pedroabinajm.thebestburgers.hamburgers.domain.Hamburger
import com.pedroabinajm.thebestburgers.hamburgers.domain.usecase.GetHamburgers
import io.reactivex.Single

class HamburgersViewModel constructor(
        private val getHamburgers: GetHamburgers,
        private val hamburgerMapper: HamburgerMapper
) : ViewModel() {
    val hamburgers = MutableLiveData<Resource<List<HamburgerModel>>>()

    fun fetchHamburgers(): Single<List<Hamburger>> {
        hamburgers.value = resourceLoading(null)
        return getHamburgers.getHamburgers(
                onNext = { hamburgers ->
                    val hamburgersModel = hamburgers.map { hamburgerMapper.transform(it) }
                    onHamburgersSuccess(hamburgersModel)
                },
                onError = { error ->
                    onHamburgersError(error)
                }
        )
    }

    private fun onHamburgersSuccess(hamburgersModel: List<HamburgerModel>) {
        hamburgers.value = resourceSuccess(hamburgersModel)
        hamburgers.value = resourceCompleted(hamburgersModel)
    }

    private fun onHamburgersError(error: Throwable) {
        hamburgers.value = resourceError(error)
    }

    fun dispose() {
        getHamburgers.dispose()
    }
}