package com.herlangga.universitieshipolabs.navigation

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
object Routes {
	const val HOME_GRAPH = "home_graph"
	const val HOME_SCREEN = "home_screen"
	const val SEARCH_SCREEN = "search_screen"
	const val FAVORITES_SCREEN = "favorites_screen"
	const val DETAIL_SCREEN = "detail_screen/{url}"

	object Args {
		const val URL = "url"
	}

	fun detailScreen(url: String) = "detail_screen/$url"
}