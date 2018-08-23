package com.pedroabinajm.thebestburgers.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.pedroabinajm.thebestburgers.domain.interactor.GetHamburgers
import com.pedroabinajm.thebestburgers.view.hamburgers.HamburgerMapper
import com.pedroabinajm.thebestburgers.view.hamburgers.HamburgersViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val getHamburgers: GetHamburgers,
        private val hamburgerMapper: HamburgerMapper
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HamburgersViewModel::class.java) ->
                HamburgersViewModel(getHamburgers, hamburgerMapper) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    inline fun <reified T : ViewModel?> viewModel(activity: FragmentActivity) =
            ViewModelProviders.of(
                    activity,
                    this
            ).get(T::class.java)
}