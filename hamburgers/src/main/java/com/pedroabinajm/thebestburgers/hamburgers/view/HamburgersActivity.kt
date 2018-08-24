package com.pedroabinajm.thebestburgers.hamburgers.view

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.os.Bundle
import com.pedroabinajm.thebestburgers.core.view.anko.AnkoActivity
import com.pedroabinajm.thebestburgers.core.view.viewmodel.Resource
import javax.inject.Inject

class HamburgersActivity : AnkoActivity<HamburgersLayout>() {
    override val ui = HamburgersLayout()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private var hamburgersViewModel: HamburgersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hamburgersViewModel = viewModelFactory.viewModel(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        hamburgersViewModel?.bind(this)
        if (hamburgersViewModel?.hamburgers?.value == null) {
            hamburgersViewModel?.fetchHamburgers()
        }
    }

    override fun onDestroy() {
        hamburgersViewModel?.dispose()
        super.onDestroy()
    }

    private fun HamburgersViewModel.bind(owner: LifecycleOwner) {
        hamburgers.observe(owner, Observer<Resource<List<HamburgerModel>>> {
            ui.resource = it
        })
    }
}