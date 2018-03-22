package com.pedroabinajm.hamburgers.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pedroabinajm.hamburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.hamburgers.mapper.HamburgerMapper
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val getHamburgers: GetHamburgers,
        private val hamburgerMapper: HamburgerMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HamburgersViewModel::class.java) -> HamburgersViewModel(getHamburgers, hamburgerMapper) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}