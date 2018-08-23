package com.pedroabinajm.thebestburgers.hamburgers.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pedroabinajm.thebestburgers.core.base.ReplaceableAdapter
import com.pedroabinajm.thebestburgers.core.extensions.inflate
import com.pedroabinajm.thebestburgers.hamburgers.R

class HamburgersAdapter : ReplaceableAdapter<HamburgerModel, HamburgersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_hamburger)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hamburgerAddressText.text = items[position].address
        holder.hamburgerNameText.text = items[position].name
        holder.hamburgerRatingText.text = holder.itemView.context.getString(
                R.string.hamburger_rating,
                items[position].rating
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val hamburgerNameText: TextView = view.findViewById(R.id.hamburger_name_text)
        val hamburgerAddressText: TextView = view.findViewById(R.id.hamburger_address_text)
        val hamburgerRatingText: TextView = view.findViewById(R.id.hamburger_rating_text)
    }
}