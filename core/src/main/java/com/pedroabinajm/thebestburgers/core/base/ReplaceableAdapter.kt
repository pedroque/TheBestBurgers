package com.pedroabinajm.thebestburgers.core.base

import android.support.annotation.MainThread
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class ReplaceableAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    private var dataVersion = 0
    private var diffCalculatorDisposable: Disposable? = null
    open var items: List<T> = listOf()
        protected set

    @MainThread
    open fun replace(update: List<T>) {
        dataVersion++
        when {
            items.isEmpty() -> {
                items = update
                notifyDataSetChanged()
            }
            update.isEmpty() -> {
                val oldSize = items.size
                items = listOf()
                notifyItemRangeRemoved(0, oldSize)
            }
            else -> calculateDiff(items, update)
        }
    }

    open fun areItemsTheSame(oldItem: Any?, newItem: Any?) = oldItem == newItem

    open fun areContentsTheSame(oldItem: Any?, newItem: Any?) = oldItem == newItem

    private fun calculateDiff(oldItems: List<T>, newItems: List<T>) {
        diffCalculatorDisposable?.dispose()
        diffCalculatorDisposable = Single.create<DiffUtil.DiffResult> {
            DiffUtil.calculateDiff(DiffCallback(oldItems, newItems))
        }.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    items = newItems
                    result.dispatchUpdatesTo(this)
                }
    }

    private inner class DiffCallback(
            private val oldItems: List<T>,
            private val newItems: List<T>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldItems.size

        override fun getNewListSize() = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                areItemsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                areContentsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
    }
}