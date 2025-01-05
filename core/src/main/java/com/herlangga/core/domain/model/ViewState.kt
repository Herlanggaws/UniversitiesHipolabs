package com.herlangga.core.domain.model

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
sealed class ViewState {
	data object Idle : ViewState()
	data object Empty : ViewState()
	data object Loading : ViewState()
	data object Content : ViewState()
	data class Error(val message: String) : ViewState()
}