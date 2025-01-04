package com.herlangga.universitieshipolabs.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.herlangga.universitieshipolabs.DetailScreen
import com.herlangga.universitieshipolabs.FavoritesScreen
import com.herlangga.universitieshipolabs.HomeScreen
import com.herlangga.universitieshipolabs.SearchScreen

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */

@Composable
internal fun AppNavigation(
	navController: NavHostController = rememberNavController(),
	modifier: Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Routes.HOME_GRAPH,
		modifier = modifier
	) {
		homeGraph(navController)
	}
}

private fun NavGraphBuilder.homeGraph(navController: NavHostController) {
	navigation(
		startDestination = Routes.HOME_SCREEN,
		route = Routes.HOME_GRAPH
	) {
		composable(
			route = Routes.HOME_SCREEN,
			enterTransition = {
				slideIntoContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(300)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Left,
					animationSpec = tween(300)
				)
			}
		) {
			HomeScreen(navController)
		}

		composable(
			route = Routes.SEARCH_SCREEN,
			enterTransition = {
				slideIntoContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Left,
					animationSpec = tween(300)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(300)
				)
			}
		) {
			SearchScreen(navController)
		}

		composable(
			route = Routes.FAVORITES_SCREEN,
			enterTransition = {
				slideIntoContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Left,
					animationSpec = tween(300)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(300)
				)
			}
		) {
			FavoritesScreen(navController)
		}

		composable(
			route = Routes.DETAIL_SCREEN,
			arguments = listOf(
				navArgument(Routes.Args.URL) {
					type = NavType.StringType
				}
			),
			enterTransition = {
				slideIntoContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Left,
					animationSpec = tween(300)
				)
			},
			exitTransition = {
				slideOutOfContainer(
					towards = AnimatedContentTransitionScope.SlideDirection.Right,
					animationSpec = tween(300)
				)
			}
		) { backStackEntry ->
			val url = backStackEntry.arguments?.getString(Routes.Args.URL) ?: ""
			DetailScreen(
				navHostController = navController,
				url = url
			)
		}
	}
}