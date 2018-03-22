package com.pedroabinajm.hamburgers.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroabinajm.hamburgers.domain.Hamburger
import com.pedroabinajm.hamburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.hamburgers.mapper.HamburgerMapper
import com.pedroabinajm.hamburgers.model.HamburgerModel
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import io.reactivex.Observable

class HamburgersViewModel constructor(
        private val getHamburgers: GetHamburgers,
        private val hamburgerMapper: HamburgerMapper
) : ViewModel() {
    val hamburgers = MutableLiveData<Resource<List<HamburgerModel>>>()

    fun fetchHamburgers(): Observable<List<Hamburger>> {
        hamburgers.postValue(Resource.loading(null))
        return getHamburgers.getHamburgers({
            val result = it.map { hamburgerMapper.transform(it) }
            hamburgers.postValue(Resource.success(result))
            hamburgers.postValue(Resource.completed(result))
        }, {
            hamburgers.postValue(Resource.error(it))
        })
    }

    fun dispose() {
        getHamburgers.dispose()
    }
}