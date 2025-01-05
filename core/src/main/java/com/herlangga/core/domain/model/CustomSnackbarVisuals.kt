package com.herlangga.core.domain.model

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals

data class CustomSnackbarVisuals(
    override val message: String = "",
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false,
    val uiText: UiText? = null,
    val state: SnackbarState = SnackbarState.ERROR
) : SnackbarVisuals {
    enum class SnackbarState {
        SUCCESS, ERROR
    }
}
