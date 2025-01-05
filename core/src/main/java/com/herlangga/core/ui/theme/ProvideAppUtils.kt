package com.herlangga.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun ProvideAppUtils(
	dimension: Dimension,
	content: @Composable () -> Unit,
) {
	val appDimens = remember { dimension }
	CompositionLocalProvider(LocalAppDimens provides appDimens) {
		content()
	}
}

val LocalAppDimens = compositionLocalOf {
	Dimension()
}

val ScreenOrientation
	@Composable
	get() = LocalConfiguration.current.orientation