package com.pedroabinajm.thebestburgers.domain.interactor

import com.pedroabinajm.thebestburgers.domain.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase<T> internal constructor(private val schedulerProvider: SchedulerProvider) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun execute(single: Single<T>,
                onNext: ((T) -> Unit),
                onError: ((Throwable) -> Unit)): Single<T> {
        single.subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(onNext, onError)
                .addDisposableToBag()
        return single
    }

    fun execute(completable: Completable,
                onComplete: () -> Unit = {},
                onError: ((Throwable) -> Unit) = {}): Completable {
        completable.subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(onComplete, onError)
                .addDisposableToBag()
        return completable
    }

    fun dispose() {
        disposables.clear()
    }

    private fun Disposable.addDisposableToBag() {
        disposables.add(this)
    }
}