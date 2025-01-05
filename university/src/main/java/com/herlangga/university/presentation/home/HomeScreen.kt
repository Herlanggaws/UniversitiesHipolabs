package com.herlangga.university.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.herlangga.core.components.IconButton
import com.herlangga.core.components.TextField
import com.herlangga.core.navigation.Destination
import com.herlangga.core.ui.theme.Heading4
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.Natural500
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens
import com.herlangga.core.utils.navigateToDetail
import com.herlangga.core.utils.navigateToFavorites
import com.herlangga.core.utils.navigateToSearch
import com.herlangga.university.R
import com.herlangga.university.presentation.component.UniversityListComponent

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun HomeScreen(
	navHostController: NavHostController
) {
	HomeComponent(navHostController)
}

@Composable
fun HomeComponent(
	navHostController: NavHostController,
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = androidx.compose.ui.Modifier
			.fillMaxSize()
			.background(White)
	) {
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = MaterialTheme.dimens.default)
				.padding(top = MaterialTheme.dimens.spaceSmall),
			text = stringResource(R.string.label_welcome),
			style = Heading4,
			color = Natural500
		)

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = MaterialTheme.dimens.default)
				.padding(top = MaterialTheme.dimens.spaceSmall),
			verticalAlignment = Alignment.CenterVertically
		) {
			TextField(
				value = "",
				hint = "Search University",
				onValueChanged = {
				},
				trailingIcon = {
					Image(
						painter = painterResource(R.drawable.ic_search_normal),
						contentDescription = null,
						modifier = Modifier
							.size(MaterialTheme.dimens.iconSmall)
							.clickable(
								interactionSource = remember { MutableInteractionSource() },
								indication = rememberRipple(bounded = false),
								onClick = {

								}
							)
					)
				},
				modifier = Modifier
					.weight(1F)
			)
			Spacer(modifier.size(16.dp))
			IconButton(
				icon = R.drawable.ic_search_normal,
				onClick = {
					navHostController.navigateToFavorites()
				},
				backgroundColor = Color.White,
				modifier = Modifier
					.size(MaterialTheme.dimens.iconExtraLarge)
					.border(width = 1.dp, color = Natural50, shape = CircleShape)
			)
		}
		Spacer(modifier.size(16.dp))
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		Spacer(modifier.size(16.dp))
		UniversityListComponent(listOf("1","","1","","1","","1","","1","","1","","1","","1","","1","","1","","1","","1",""), modifier = Modifier.fillMaxWidth()) {
			navHostController.navigateToDetail(Destination.DetailScreen(url = it))
		}
		Button(onClick = {
			navHostController.navigateToSearch()
		}) {
			Text(text = "Go to search")
		}
	}
}
