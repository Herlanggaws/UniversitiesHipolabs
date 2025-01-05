package com.herlangga.university.presentation.search

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.herlangga.core.components.CustomToolbar
import com.herlangga.core.components.IconButton
import com.herlangga.core.components.TextField
import com.herlangga.core.navigation.Destination
import com.herlangga.core.ui.theme.Black
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens
import com.herlangga.core.utils.navigateToDetail
import com.herlangga.core.utils.navigateToFavorites
import com.herlangga.core.utils.navigateToSearch
import com.herlangga.university.R
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.presentation.component.UniversityListComponent
import com.herlangga.university.presentation.home.HomeEvent
import com.herlangga.university.presentation.home.HomeUIState

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun SearchScreen(
	navHostController: NavHostController,
	viewModel: SearchViewModel = hiltViewModel()
) {
	val lifecycleOwner = LocalLifecycleOwner.current
	LaunchedEffect(key1 = Unit) {
		viewModel.getAllUniversity(
			UniversityQueryParams("", "")
		)
		viewModel.uiEvent.flowWithLifecycle(lifecycleOwner.lifecycle)
			.collect(navHostController::onEvent)
	}
	val uiState = viewModel.uiState.collectAsStateWithLifecycle()
	SearchComponent(
		uiState = uiState,
		eventSender = viewModel::onEvent
	)
}

@Composable
fun SearchComponent(
	uiState: State<SearchUIState>,
	modifier: Modifier = Modifier,
	eventSender: (SearchEvent) -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(White)
	) {
		CustomToolbar(
			title = stringResource(R.string.label_search),
			onBackPressed = {
				eventSender(SearchEvent.NavigateUp)
			}
		)
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {
			TextField(
				value = uiState.value.query,
				hint = "Search University",
				onValueChanged = {
					eventSender(SearchEvent.OnSearch(it))
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
				modifier = Modifier.padding(16.dp)
			)
		}
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		UniversityListComponent(uiState.value.universityList, uiState.value.viewState, modifier = Modifier.fillMaxWidth()) {
			eventSender(SearchEvent.NavigateToUniversityDetail(it))
		}
	}
}

@Preview
@Composable
fun SearchComponentPreview() {
	val uiState: State<SearchUIState> = remember {
		mutableStateOf(
			SearchUIState(
				universityList = listOf(),
			)
		)
	}
	SearchComponent(uiState) { }
}

private fun NavHostController.onEvent(event: SearchEvent) {
	when (event) {
		SearchEvent.NavigateUp -> popBackStack()
		is SearchEvent.NavigateToUniversityDetail -> navigateToDetail(Destination.DetailScreen(event.url))
		else -> {}
	}
}
