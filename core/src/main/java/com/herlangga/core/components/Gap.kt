package com.herlangga.core.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun ColumnScope.Gap(size: Dp) {
	Gap(vertical = size)
}

@Composable
fun RowScope.Gap(size: Dp) {
	Gap(horizontal = size)
}

@Composable
fun Gap(horizontal: Dp = 0.dp, vertical: Dp = 0.dp) {
	Spacer(Modifier.size(horizontal, vertical))
}