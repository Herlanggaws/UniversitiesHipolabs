package com.herlangga.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    val code: Int? = null,
    val success: Boolean? = null,
    val error: String? = null,
    val message: String? = null
)
