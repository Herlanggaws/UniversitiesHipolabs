package com.herlangga.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.herlangga.core.R
import com.herlangga.core.ui.theme.Natural00
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.Success
import com.herlangga.core.ui.theme.dimens

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun IconButton(
	icon: Int,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	backgroundColor: Color = Natural00,
	iconSize: Dp = 16.dp,
	size: Dp = 36.dp,
	iconColor: Color? = null,
) {
	Box(
		modifier = modifier
			.size(size)
			.clip(CircleShape)
			.background(backgroundColor)
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = rememberRipple(bounded = false),
				onClick = {
					onClick()
				}
			)
	) {
		Image(
			painter = painterResource(id = icon),
			contentDescription = null,
			colorFilter = iconColor?.let { ColorFilter.tint(color = it) },
			modifier = Modifier.size(iconSize).align(Alignment.Center)
		)
	}
}

@Preview
@Composable
fun PreviewCommonIconButton() {
	IconButton(
		icon = R.drawable.ic_placeholder,
		onClick = {},
		backgroundColor = Color.White,
		modifier = Modifier
			.size(MaterialTheme.dimens.iconExtraLarge)
			.border(width = 1.dp, color = Natural50, shape = CircleShape)
	)
}