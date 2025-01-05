package com.herlangga.university.presentation.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.herlangga.core.ui.theme.Blue200
import com.herlangga.core.ui.theme.Blue500
import kotlinx.coroutines.delay

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BannerSlider() {
	val banners = listOf(
		"Explore top-rated universities\nAchieve your dreams",
		"Plan your future education\nApply today",
		"Discover affordable programs\nStart your journey now",
		"Find your perfect university match\nWith ease",
		"Unlock endless opportunities\nStart learning today"
	)

	var currentBannerIndex by remember { mutableStateOf(0) }

	// Automatically change the banner every 3 seconds
	LaunchedEffect(currentBannerIndex) {
		delay(3000L)
		currentBannerIndex = (currentBannerIndex + 1) % banners.size
	}

	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(150.dp)
			.padding(16.dp),
		contentAlignment = Alignment.Center
	) {
		AnimatedContent(
			targetState = currentBannerIndex,
			transitionSpec = {
				slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) with
						slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth })
			}
		) { targetIndex ->
			BasicText(
				text = banners[targetIndex],
				style = TextStyle(
					color = Blue500,
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold
				),
				modifier = Modifier
					.wrapContentSize(Alignment.Center)
			)
		}
	}
}