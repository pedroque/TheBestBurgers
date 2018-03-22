package com.pedroabinajm.hamburgers.view.hamburgers

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.pedroabinajm.hamburgers.model.HamburgerModel
import com.pedroabinajm.hamburgers.view.base.BaseActivity
import com.pedroabinajm.hamburgers.viewmodel.HamburgersViewModel
import com.pedroabinajm.hamburgers.viewmodel.ViewModelFactory
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import javax.inject.Inject

class HamburgersActivity : BaseActivity<HamburgersLayout>() {
    override val ui = HamburgersLayout()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private var hamburgersViewModel: HamburgersViewModel? = null
    private var hamburgersAdapter: HamburgersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hamburgersViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HamburgersViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        hamburgersAdapter = HamburgersAdapter()
        ui.recyclerView.adapter = hamburgersAdapter

        hamburgersViewModel?.run {
            bind()
            if (hamburgers.value == null) {
                fetchHamburgers()
            }
        }
    }

    override fun onDestroy() {
        hamburgersViewModel?.dispose()
        super.onDestroy()
    }

    private fun HamburgersViewModel.bind() {
        hamburgers.observe(this@HamburgersActivity, Observer<Resource<List<HamburgerModel>>> {
            ui.resource = it
            it?.let {
                if (!it.isEmpty) hamburgersAdapter?.replace(it.data!!)
            }
        })
    }
}