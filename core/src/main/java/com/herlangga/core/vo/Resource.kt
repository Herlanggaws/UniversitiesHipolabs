package com.shoolryde.core.vo

sealed class Resource<out T: Any?> {
    data class Success<out T: Any?>(val data: T): Resource<T>()
    data class Error(val message: String, val code: Int? = null): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}