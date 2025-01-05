package com.herlangga.core.utils

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.IntSize

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun Modifier.clickWithRipple(onClick: () -> Unit): Modifier = composed {
	clickable(
		interactionSource = remember { MutableInteractionSource() },
		indication = rememberRipple(bounded = false),
		onClick = onClick
	)
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
	clickable(
		indication = null,
		interactionSource = remember { MutableInteractionSource() },
		onClick = onClick
	)
}

fun Modifier.shimmerEffect(): Modifier = composed {
	var size by remember {
		mutableStateOf(IntSize.Zero)
	}
	val transition = rememberInfiniteTransition(label = "")
	val startOffsetX by transition.animateFloat(
		initialValue = -2 * size.width.toFloat(),
		targetValue = 2 * size.width.toFloat(),
		animationSpec = infiniteRepeatable(
			animation = tween(2000)
		),
		label = ""
	)

	background(
		brush = Brush.linearGradient(
			colors = listOf(
				Color(0xFFB8B5B5),
				Color(0xFF8F8B8B),
				Color(0xFFB8B5B5),
			),
			start = Offset(startOffsetX, 0f),
			end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
		)
	)
		.onGloballyPositioned { newPosition ->
			if (size != newPosition.size) {
				size = newPosition.size
			}
		}
}

fun Modifier.clickable(
	enabled: Boolean = true,
	showRipple: Boolean = true,
	onClickLabel: String? = null,
	role: Role? = null,
	onClick: () -> Unit,
): Modifier = composed {
	clickable(
		interactionSource = remember { MutableInteractionSource() },
		indication = if (showRipple) LocalIndication.current else null,
		enabled = enabled,
		onClickLabel = onClickLabel,
		role = role,
		onClick = onClick,
	)
}