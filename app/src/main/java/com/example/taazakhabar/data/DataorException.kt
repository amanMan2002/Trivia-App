package com.example.taazakhabar.data

data class DataorException<T,Boolean,E: Exception> (
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: E? = null)

