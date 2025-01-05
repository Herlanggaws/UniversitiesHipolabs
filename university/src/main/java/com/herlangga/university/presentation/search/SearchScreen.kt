package com.herlangga.university.presentation.search

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.herlangga.core.components.IconButton
import com.herlangga.core.components.TextField
import com.herlangga.core.ui.theme.Black
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens
import com.herlangga.university.R
import com.herlangga.university.presentation.home.HomeEvent

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun SearchScreen (
	navHostController: NavHostController
) {
	SearchComponent {  }
}

@Composable
fun SearchComponent(
	modifier: Modifier = Modifier,
	eventSender: (SearchEvent) -> Unit
) {
	Column(
		modifier = androidx.compose.ui.Modifier
			.fillMaxSize()
			.background(White)
	) {
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
		}
	}
}