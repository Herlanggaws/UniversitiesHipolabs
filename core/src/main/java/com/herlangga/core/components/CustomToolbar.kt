package com.herlangga.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.herlangga.core.R
import com.herlangga.core.ui.theme.Heading7
import com.herlangga.core.ui.theme.Natural700
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens
import com.herlangga.core.utils.clickWithRipple

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun CustomToolbar(
	onBackPressed: () -> Unit,
	modifier: Modifier = Modifier,
	title: String = "",
	icon: Int = R.drawable.ic_arrow_left,
	height: Dp = MaterialTheme.dimens.toolbarHeight,
	iconSize: Dp = MaterialTheme.dimens.iconMedium,
	textStyle: TextStyle = Heading7,
	textColor: Color = Natural700,
	horizontalPadding: Dp = MaterialTheme.dimens.default
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.height(height)
			.background(White)
			.padding(horizontal = horizontalPadding),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(12.dp)
	) {
		Image(
			painter = painterResource(id = icon),
			contentDescription = null,
			modifier = Modifier
				.size(iconSize)
				.clickWithRipple { onBackPressed() }
		)
		if (title.isNotEmpty()) {
			Text(
				text = title,
				color = textColor,
				style = textStyle
			)
		}
	}
}

@Preview
@Composable
fun PreviewCommonToolbar() {
	CustomToolbar(
		title = "Detail",
		onBackPressed = { /*TODO*/ },
	)
}