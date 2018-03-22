package com.pedroabinajm.hamburgers.view.hamburgers

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class HamburgersAdapter : RecyclerView.Adapter<HamburgersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        return null
    }

    override fun getItemCount() = 0

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}