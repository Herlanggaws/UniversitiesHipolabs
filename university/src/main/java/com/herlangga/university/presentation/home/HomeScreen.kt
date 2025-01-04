package com.herlangga.university.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.herlangga.core.navigation.Destination
import com.herlangga.core.ui.theme.Black
import com.herlangga.core.ui.theme.White
import com.herlangga.core.utils.navigateToDetail
import com.herlangga.core.utils.navigateToFavorites
import com.herlangga.core.utils.navigateToSearch

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun HomeScreen(
	navHostController: NavHostController
) {
	Column(
		modifier = androidx.compose.ui.Modifier
			.fillMaxSize()
			.background(White)
	) {
		Text(
			text = "Universities Hipolabs",
			color = Black
		)
		Button(
			onClick = {
				navHostController.navigateToDetail(
					Destination.DetailScreen(url = "https://www.google.com")
				)
			},
			modifier = Modifier.padding(horizontal = 16.dp)
		) {
			Text(text = "Go to detail")
		}
		Button(onClick = {
			navHostController.navigateToSearch()
		}) {
			Text(text = "Go to search")
		}
		Button(onClick = {
			navHostController.navigateToFavorites()
		}) {
			Text(text = "Go to fav")
		}
	}
}