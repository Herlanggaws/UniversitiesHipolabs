package com.herlangga.university.presentation.component

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.herlangga.core.components.MultiStateView
import androidx.compose.runtime.State
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens
import com.herlangga.university.presentation.home.HomeUIState

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun UniversityListComponent(
	uiState: State<HomeUIState>,
	modifier: Modifier = Modifier,
	onItemClicked: (String) -> Unit = {}
) {
	MultiStateView(state = uiState.value.viewState, loadingLayout = {
		LazyColumn(
			modifier = Modifier
				.fillMaxWidth()
				.padding(MaterialTheme.dimens.spaceSmallMedium),
			verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceTinyLarge)
		) {
			items(10) {
				StudentScheduleShimmer()
			}
		}
	}, emptyLayout = {
		EmptyUniveristyComponent()
	}, content = {
		LazyColumn(
			modifier = modifier
				.fillMaxSize()
				.background(White)
				.animateContentSize(),
			verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceSmall)
		) {
			items(items = uiState.value.universityList) {
				UniversityItem(
					it.name,
					it.webPage.first()
				) { webPage ->
					onItemClicked(webPage)
				}
			}
		}
	})
}