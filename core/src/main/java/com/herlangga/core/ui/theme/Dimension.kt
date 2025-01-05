package com.herlangga.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class Dimension(
 val default: Dp = 20.dp,
 val hug: Dp = 31.dp,
 val spaceExtraTiny: Dp = 3.dp,
 val spaceTiny: Dp = 8.dp,
 val spaceTinyMedium: Dp = 10.dp,
 val spaceTinyLarge: Dp = 12.dp,
 val spaceSmall: Dp = 14.dp,
 val spaceSmallMedium: Dp = 18.dp,
 val spaceMedium: Dp = 24.dp,
 val spaceMediumLarge: Dp = 29.dp,
 val spaceLarge: Dp = 32.dp,
 val spaceExtraLarge: Dp = 56.dp,
 val buttonHeight: Dp = 52.dp,
 val outlineButtonHeight: Dp = 49.dp,
 val textFieldHeight: Dp = 41.dp,
 val largeTextFieldHeight: Dp = 51.dp,
 val textAreaHeight: Dp = 108.dp,
 val defaultRoundedSize: Dp = 7.dp,
 val mediumRoundedSize: Dp = 14.dp,
 val iconTiny: Dp = 12.dp,
 val iconSmall: Dp = 14.dp,
 val iconMedium: Dp = 17.dp,
 val iconLarge: Dp = 24.dp,
 val iconExtraLarge: Dp = 41.dp,
 val toolbarHeight: Dp = 46.dp,
 val bottomBarHeight: Dp = 59.dp,
 val bottomSheetCorner: Dp = 18.dp
)

// TODO: Determine MediumDimension
val MediumDimension = Dimension()

// TODO: Determine ExpandedDimension
val ExpandedDimension = Dimension()

val MaterialTheme.dimens
 @Composable
 get() = LocalAppDimens.current