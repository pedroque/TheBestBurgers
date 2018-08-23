package com.pedroabinajm.thebestburgers.view.hamburgers

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroabinajm.thebestburgers.domain.Hamburger
import com.pedroabinajm.thebestburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.thebestburgers.viewmodel.Resource
import io.reactivex.Single

class HamburgersViewModel constructor(
        private val getHamburgers: GetHamburgers,
        private val hamburgerMapper: HamburgerMapper
) : ViewModel() {
    val hamburgers = MutableLiveData<Resource<List<HamburgerModel>>>()

    fun fetchHamburgers(): Single<List<Hamburger>> {
        hamburgers.postValue(Resource.loading(null))
        return getHamburgers.getHamburgers(
                onNext = { hamburgers ->
                    val hamburgersModel = hamburgers.map { hamburgerMapper.transform(it) }
                    this@HamburgersViewModel.hamburgers.postValue(
                            Resource.success(hamburgersModel)
                    )
                    this@HamburgersViewModel.hamburgers.postValue(
                            Resource.completed(hamburgersModel)
                    )
                },
                onError = {
                    hamburgers.postValue(Resource.error(it))
                }
        )
    }

    fun dispose() {
        getHamburgers.dispose()
    }
}