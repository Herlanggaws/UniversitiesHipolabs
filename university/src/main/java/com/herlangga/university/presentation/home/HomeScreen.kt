package com.herlangga.university.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.herlangga.core.navigation.Destination
import com.herlangga.core.ui.theme.Blue500
import com.herlangga.core.ui.theme.Heading5
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.White
import com.herlangga.core.utils.clickable
import com.herlangga.core.utils.navigateToDetail
import com.herlangga.core.utils.navigateToFavorites
import com.herlangga.core.utils.navigateToSearch
import com.herlangga.university.R
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.presentation.component.BannerSlider
import com.herlangga.university.presentation.component.ScholarshipButton
import com.herlangga.university.presentation.component.UniversityListComponent

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun HomeScreen(
	navHostController: NavHostController,
	viewModel: HomeViewModel = hiltViewModel()
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

	HomeComponent(
		uiState = uiState,
		eventSender = viewModel::onEvent
	)
}

@Composable
fun HomeComponent(
	uiState: State<HomeUIState>,
	modifier: Modifier = Modifier,
	eventSender: (HomeEvent) -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(White)
	) {
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		BannerSlider()
		Spacer(modifier.size(16.dp))
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			ScholarshipButton(
				modifier = Modifier.weight(1F)
			) {
				eventSender(HomeEvent.NavigateToSearch)
			}
			Spacer(modifier = Modifier.padding(8.dp))
			ScholarshipButton(
				modifier = Modifier.weight(1F)
			) {
				eventSender(HomeEvent.NavigateToSearch)
			}
		}
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				modifier = Modifier.weight(1F),
				text = stringResource(R.string.label_the_university),
				style = Heading5,
				color = Blue500
			)
			Text(
				modifier = Modifier.weight(1F).clickable {
					eventSender(HomeEvent.NavigateToSearch)
				},
				text = stringResource(R.string.label_see_all),
				style = Heading5,
				color = Blue500,
				textAlign = TextAlign.End
			)
		}
		Spacer(modifier = Modifier.padding(8.dp))
		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
		UniversityListComponent(uiState.value.universityList, viewState = uiState.value.viewState, modifier = Modifier.fillMaxWidth()) {
			eventSender(HomeEvent.NavigateToUniversityDetail(it))
		}
	}
}

@Preview
@Composable
fun HomeComponentPreview() {
	val uiState: State<HomeUIState> = remember {
		mutableStateOf(
			HomeUIState(
				universityList = listOf(),
			)
		)
	}
	HomeComponent(
		uiState = uiState
	) { }
}


private fun NavHostController.onEvent(event: HomeEvent) {
	when (event) {
		HomeEvent.NavigateUp -> popBackStack()
		HomeEvent.NavigateToSearch -> {
			navigateToSearch()
		}

		is HomeEvent.NavigateToUniversityDetail -> navigateToDetail(Destination.DetailScreen(url = event.url))
		HomeEvent.NavigateToFav -> navigateToFavorites()
	}
}

