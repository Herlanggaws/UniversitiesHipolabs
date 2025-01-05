package com.herlangga.university.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.herlangga.core.ui.theme.Blue200
import com.herlangga.core.ui.theme.Blue500
import com.herlangga.core.ui.theme.Heading5
import com.herlangga.core.ui.theme.Natural00
import com.herlangga.core.ui.theme.Natural500
import com.herlangga.core.ui.theme.White
import com.herlangga.university.R

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Preview
@Composable
fun ScholarshipButton(
	modifier: Modifier = Modifier,
	onItemClicked: () -> Unit = {}
) {
	Column(
		modifier = modifier
			.height(IntrinsicSize.Min)
			.clip(RoundedCornerShape(5.dp))
			.border(width = 1.dp, color = Natural00, shape = RoundedCornerShape(5.dp))
			.background(White)
			.padding(10.dp)
			.clickable { onItemClicked() }
	) {
		Text(
			text = stringResource(R.string.label_get_scholarship_in_bandung),
			maxLines = 5,
			style = Heading5,
			color = Blue500
		)
		Spacer(modifier = Modifier.height(48.dp))
		Text(
			text = stringResource(R.string.label_find_now),
			maxLines = 5,
			style = Heading5,
			color = Natural500
		)
	}
}