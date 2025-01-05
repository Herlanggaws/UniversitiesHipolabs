package com.herlangga.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.herlangga.core.R

val Satoshi = FontFamily(
	listOf(
		Font(R.font.satoshi_black, FontWeight.Black),
		Font(R.font.satoshi_bold, FontWeight.Bold),
		Font(R.font.satoshi_light, FontWeight.Light),
		Font(R.font.satoshi_medium, FontWeight.Medium),
		Font(R.font.satoshi_regular, FontWeight.Normal),
	)
)

val SFProText = FontFamily(
	listOf(
		Font(R.font.sf_pro_text_heavy, FontWeight.Black),
		Font(R.font.sf_pro_text_bold, FontWeight.Bold),
		Font(R.font.sf_pro_text_light, FontWeight.Light),
		Font(R.font.sf_pro_text_medium, FontWeight.Medium),
		Font(R.font.sf_pro_text_regular, FontWeight.Normal),
	)
)

// Set of Material typography styles to start with
val Typography = Typography(
	displayLarge = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 52.sp
	),
	displayMedium = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 56.sp
	),
	displaySmall = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 48.sp
	),
	headlineLarge = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 40.sp
	),
	headlineMedium = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 32.sp,
		lineHeight = 42.sp
	),
	headlineSmall = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 24.sp,
		lineHeight = 31.2.sp
	),
	titleLarge = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 21.sp,
		lineHeight = 27.3.sp
	),
	titleMedium = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 18.sp,
		lineHeight = 23.4.sp
	),
	titleSmall = TextStyle(
		fontFamily = Satoshi,
		fontWeight = FontWeight.Bold,
		fontSize = 16.sp,
		lineHeight = 20.8.sp
	),
	bodyLarge = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 24.sp,
		lineHeight = 36.sp
	),
	bodyMedium = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 20.sp,
		lineHeight = 34.sp
	),
	bodySmall = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 27.2.sp
	),
	labelLarge = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 14.sp,
		lineHeight = 23.8.sp
	),
	labelMedium = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 12.sp,
		lineHeight = 18.sp
	),
	labelSmall = TextStyle(
		fontFamily = SFProText,
		fontWeight = FontWeight.Normal,
		fontSize = 10.sp,
		lineHeight = 17.sp
	),
)