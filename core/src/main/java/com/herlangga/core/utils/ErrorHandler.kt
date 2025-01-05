package com.herlangga.core.utils

import com.herlangga.core.domain.model.ErrorMessage
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.retrofit.serialization.deserializeErrorBody

fun ApiResponse.Failure.Error.getErrorMessage(): String {
    val errorBody = deserializeErrorBody<String, ErrorMessage>()
    return errorBody?.error ?: errorBody?.message.orEmpty()
}