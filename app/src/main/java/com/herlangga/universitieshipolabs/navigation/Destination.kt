package com.herlangga.universitieshipolabs.navigation

import kotlinx.serialization.Serializable

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
sealed interface Destination {
	@Serializable
	data object HomeGraph : Destination

	@Serializable
	data object HomeScreen : Destination

	@Serializable
	data object SearchScreen : Destination

	@Serializable
	data object FavoritesScreen : Destination

	@Serializable
	data class DetailScreen(val url: String) : Destination
}