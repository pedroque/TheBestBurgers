package com.pedroabinajm.thebestburgers.core.viewmodel

data class Resource<out T>(
        val status: Status,
        val data: T? = null,
        val error: Throwable? = null
) {
    val isEmpty: Boolean
        get() = data == null || (data is Collection<*> && data.isEmpty())

    enum class Status {
        SUCCESS, ERROR, LOADING, COMPLETED
    }
}

fun <T> resourceLoading(data: T?) = Resource(Resource.Status.LOADING, data)
fun <T> resourceSuccess(data: T?) = Resource(Resource.Status.SUCCESS, data)
fun <T> resourceCompleted(data: T?) = Resource(Resource.Status.COMPLETED, data)
fun <T> resourceError(
        error: Throwable?,
        data: T? = null
) = Resource(Resource.Status.ERROR, data, error)