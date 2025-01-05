package com.herlangga.core.base

import com.herlangga.core.domain.model.SnackbarMessage
import com.herlangga.core.domain.model.UiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
object SnackBarState {
	private val _snackBar = MutableStateFlow<SnackbarMessage?>(null)
	val snackBar = _snackBar.asStateFlow()

	fun showErrorSnackBar(message: UiText) {
		_snackBar.update {
			SnackbarMessage.showErrorMessage(message)
		}
	}

	fun showSuccessSnackBar(message: UiText) {
		_snackBar.update {
			SnackbarMessage.showSuccessMessage(message)
		}
	}

	fun dismissSnackBar() {
		_snackBar.update { null }
	}
}