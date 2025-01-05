package com.herlangga.university.presentation.component

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
import com.herlangga.core.domain.model.ViewState
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun UniversityListComponent(
	universityList: List<String>,
	modifier: Modifier = Modifier,
	onItemClicked: (String) -> Unit = {}
) {
	MultiStateView(state = ViewState.Loading, loadingLayout = {
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
			items(items = universityList) {
				UniversityItem() {
					onItemClicked("gunadarma.ac.id")
				}
			}
		}
	})
}