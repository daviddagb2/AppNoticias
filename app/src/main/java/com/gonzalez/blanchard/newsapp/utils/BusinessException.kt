package com.gonzalez.blanchard.newsapp.utils

open class BusinessException(
    val errorType: ErrorType = ErrorType.UNEXPECTED,
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause)
