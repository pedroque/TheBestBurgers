package com.pedroabinajm.hamburgers.view.hamburgers

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.pedroabinajm.hamburgers.model.HamburgerModel
import com.pedroabinajm.hamburgers.view.anko.ActivityAnkoComponent
import com.pedroabinajm.hamburgers.view.styles.errorText
import com.pedroabinajm.hamburgers.view.styles.fixedSizeRecyclerView
import com.pedroabinajm.hamburgers.view.styles.progressBar
import com.pedroabinajm.hamburgers.viewmodel.commons.Resource
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.verticalLayout

class HamburgersLayout : ActivityAnkoComponent<HamburgersActivity> {

    var resource: Resource<List<HamburgerModel>>? = null
    override var toolbar: Toolbar? = null
    lateinit var recyclerView: RecyclerView

    override fun createView(ui: AnkoContext<HamburgersActivity>) = with(ui) {
        verticalLayout {
            toolbar = toolbar().lparams(width = matchParent)

            relativeLayout {
                recyclerView = fixedSizeRecyclerView(LinearLayoutManager(context), resource)
                        .lparams(matchParent, matchParent)

                errorText(resource)
                        .lparams {
                            centerInParent()
                        }

                progressBar(resource)
                        .lparams {
                            centerInParent()
                        }
            }
        }
    }

}