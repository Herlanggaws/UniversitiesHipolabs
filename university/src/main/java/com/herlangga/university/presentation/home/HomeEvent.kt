package com.herlangga.university.presentation.home

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
sealed class HomeEvent {
	data object NavigateUp : HomeEvent()
	data class NavigateToUniversityDetail(val url: String) : HomeEvent()
	data object NavigateToSearch: HomeEvent()
	data object NavigateToFav: HomeEvent()
}