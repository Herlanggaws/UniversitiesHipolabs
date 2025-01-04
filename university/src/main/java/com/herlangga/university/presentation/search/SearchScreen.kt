package com.herlangga.university.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.herlangga.core.ui.theme.Black
import com.herlangga.core.ui.theme.White

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun SearchScreen (
	navHostController: NavHostController
) {
	Column(
		modifier = androidx.compose.ui.Modifier
			.fillMaxSize()
			.background(White)
	) {
		Text(
			text = "Search Screen",
			color = Black
		)
		Button(onClick = {
			navHostController.navigateUp()
		}) {
			Text(text = "Go to detail")
		}
	}
}