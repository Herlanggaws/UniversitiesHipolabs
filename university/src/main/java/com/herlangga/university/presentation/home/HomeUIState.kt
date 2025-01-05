package com.herlangga.university.presentation.home

import com.herlangga.core.domain.model.ViewState
import com.herlangga.university.domain.model.University

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class HomeUIState(
	val universityList: List<University> = emptyList(),
	val viewState: ViewState = ViewState.Content,
)