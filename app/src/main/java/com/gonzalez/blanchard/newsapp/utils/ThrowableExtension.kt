package com.gonzalez.blanchard.newsapp.utils

import java.net.UnknownHostException

fun Throwable.parseException() : BusinessException =
    when(this){
        is UnknownHostException -> BusinessException(ErrorType.CONNECTIVITY_ERROR, cause = this)
        is BusinessException -> this
        else ->  BusinessException(cause = this)
    }
