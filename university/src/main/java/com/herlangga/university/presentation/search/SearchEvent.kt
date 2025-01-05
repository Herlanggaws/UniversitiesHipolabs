package com.herlangga.university.presentation.search

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
sealed class SearchEvent {
	data object NavigateUp : SearchEvent()
	data class OnSearch(val query: String) : SearchEvent()
	data class NavigateToUniversityDetail(val url: String): SearchEvent()
}