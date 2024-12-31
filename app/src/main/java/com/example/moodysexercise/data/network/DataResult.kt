package com.example.moodysexercise.data.network

//this allows extensibility of the network layer, without coupling it to the UI
sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val message: String) : DataResult<Nothing>()
    data object Loading : DataResult<Nothing>()
    data object Empty : DataResult<Nothing>()
}
