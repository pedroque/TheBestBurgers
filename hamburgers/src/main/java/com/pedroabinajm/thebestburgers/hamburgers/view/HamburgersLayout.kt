package com.pedroabinajm.thebestburgers.hamburgers.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ProgressBar
import com.pedroabinajm.thebestburgers.core.view.anko.ActivityAnkoComponent
import com.pedroabinajm.thebestburgers.core.view.anko.ErrorTextView
import com.pedroabinajm.thebestburgers.core.view.anko.errorText
import com.pedroabinajm.thebestburgers.core.view.anko.progressBar
import com.pedroabinajm.thebestburgers.core.view.anko.recyclerView
import com.pedroabinajm.thebestburgers.core.view.anko.setResource
import com.pedroabinajm.thebestburgers.core.view.viewmodel.Resource
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.verticalLayout

class HamburgersLayout : ActivityAnkoComponent<HamburgersActivity> {
    override var toolbar: Toolbar? = null
    private var recyclerView: RecyclerView? = null
    private var errorText: ErrorTextView? = null
    private var progressBar: ProgressBar? = null
    private val hamburgersAdapter = HamburgersAdapter()

    var resource: Resource<List<HamburgerModel>>? = null
        set(value) {
            field = value
            errorText?.setResource(field)
            progressBar?.setResource(field)
            recyclerView?.setResource(field)
            hamburgersAdapter.replace(field?.data ?: listOf())
        }

    override fun createView(ui: AnkoContext<HamburgersActivity>) = with(ui) {
        verticalLayout {
            toolbar = toolbar {
                lparams(width = matchParent)
            }

            relativeLayout {
                lparams(matchParent, matchParent)

                recyclerView = recyclerView {
                    lparams(matchParent, matchParent)
                    setResource(resource)
                    layoutManager = LinearLayoutManager(context)
                    adapter = hamburgersAdapter
                }

                errorText = errorText {
                    lparams {
                        centerInParent()
                    }
                    setResource(resource)
                }

                progressBar = progressBar {
                    lparams {
                        centerInParent()
                    }
                    setResource(resource)
                }
            }
        }
    }
}