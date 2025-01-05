package com.herlangga.university.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.herlangga.core.ui.theme.Blue500
import com.herlangga.core.ui.theme.Body5
import com.herlangga.core.ui.theme.Heading6
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.Purple40
import com.herlangga.core.ui.theme.White
import com.herlangga.core.utils.clickable
import com.herlangga.university.R

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun UniversityItem(
	modifier: Modifier = Modifier,
	OnStudentClick:() -> Unit
) {
	Column(
		modifier = modifier
			.background(White)
	) {
		Row (
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Column(
				modifier = modifier
					.weight(1F)
					.background(White)
			) {
				Text(
					text = "Universitas Indonesia",
					style = Heading6,
					color = Blue500
				)
				Spacer(modifier.size(8.dp))
				Text(
					modifier = Modifier.clickable {
						OnStudentClick()
					},
					text = stringResource(R.string.label_visit_site),
					style = Body5,
					color = Purple40
				)
			}

			Text(
				text = stringResource(R.string.label_add_to_fav),
				style = Heading6,
				color = Blue500
			)
		}


		HorizontalDivider(
			color = Natural50,
			thickness = 1.dp
		)
	}
}

@Preview
@Composable
fun UniversityItemPreview() {
	UniversityItem(modifier = Modifier) {

	}
}