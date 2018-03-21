package com.pedroabinajm.hamburgers.domain.interactor

import com.pedroabinajm.hamburgers.domain.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase<T> internal constructor(private val schedulerProvider: SchedulerProvider) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Executes the current use case.
     */
    fun execute(observable: Observable<T>,
                onNext: ((T) -> Unit),
                onError: ((Throwable) -> Unit)): Observable<T> {
        addDisposable(observable.subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(onNext, onError))
        return observable
    }

    fun execute(completable: Completable,
                onComplete: () -> Unit = {},
                onError: ((Throwable) -> Unit) = {}): Completable {
        addDisposable(completable.subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(onComplete, onError))
        return completable
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        disposables.clear()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}