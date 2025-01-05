package com.herlangga.core.utils

import androidx.navigation.NavHostController
import com.herlangga.core.navigation.Destination
import com.herlangga.core.navigation.Routes
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun NavHostController.navigateToDetail(destination: Destination.DetailScreen) {
	val encodedUrl = URLEncoder.encode(destination.url, StandardCharsets.UTF_8.toString())
	navigate(Routes.detailScreen(encodedUrl))
}

fun NavHostController.navigateToSearch() {
	navigate(Routes.SEARCH_SCREEN)
}

fun NavHostController.navigateToFavorites() {
	navigate(Routes.FAVORITES_SCREEN)
}

fun NavHostController.navigateToHome() {
	navigate(Routes.HOME_SCREEN) {
		popUpTo(Routes.HOME_GRAPH) {
			saveState = true
		}
	}
}