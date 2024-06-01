package com.gonzalez.blanchard.newsapp.utils

import androidx.annotation.VisibleForTesting
import okhttp3.ResponseBody
import retrofit2.Response

inline fun <reified T> Response<T>.parseResponse(): T {
    val body = this.body()
    if (this.isSuccessful && body != null) {
        return body
    } else {
        throw BusinessException(
            getErrorType(this.code(), this.errorBody()),
            "$this.code() $this.message()"
        )
    }
}


@Suppress("UNUSED_PARAMETER")
@VisibleForTesting
fun getErrorType(code: Int, errorBody: ResponseBody?): ErrorType {
    return when (code) {
        401 -> ErrorType.UNAUTHORIZED
        403 -> ErrorType.FORBIDDEN
        409 -> ErrorType.CONFLICT
        else -> ErrorType.UNEXPECTED
    }
}