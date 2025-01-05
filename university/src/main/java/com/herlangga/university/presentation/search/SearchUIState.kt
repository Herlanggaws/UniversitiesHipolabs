package com.herlangga.university.presentation.search

import com.herlangga.core.domain.model.ViewState
import com.herlangga.university.domain.model.University

/**
 * Designed and developed by Herlangga Wicaksono on 06/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class SearchUIState(
	val universityList: List<University> = emptyList(),
	val query: String = "",
	val viewState: ViewState = ViewState.Content,
)