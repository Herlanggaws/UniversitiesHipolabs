package com.herlangga.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.herlangga.core.ui.theme.Body4
import com.herlangga.core.ui.theme.Natural00
import com.herlangga.core.ui.theme.Natural400
import com.herlangga.core.ui.theme.Natural50
import com.herlangga.core.ui.theme.Natural700
import com.herlangga.core.ui.theme.White
import com.herlangga.core.ui.theme.dimens

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun TextField(
	value: String,
	hint: String = "",
	onValueChanged: (String) -> Unit,
	shape: Shape = RoundedCornerShape(MaterialTheme.dimens.defaultRoundedSize),
	visualTransformation: VisualTransformation = VisualTransformation.None,
	textStyle: TextStyle = Body4.copy(lineHeight = 16.71.sp, color = Natural700),
	hintColor: Color = Natural400,
	trailingIcon: @Composable (() -> Unit)? = null,
	modifier: Modifier
) {

	val interactionSource = remember { MutableInteractionSource() }

	val focusRequester = remember {
		FocusRequester()
	}

	val isFocused by interactionSource.collectIsFocusedAsState()

	val borderColor = when {
		isFocused -> Blue
		else -> Natural50
	}

	val containerColor = if (isFocused) Natural00 else White
	BasicTextField(
		value = value,
		modifier = modifier,
		onValueChange = {
			onValueChanged(it)
		},
		visualTransformation = visualTransformation,
		interactionSource = interactionSource,
		enabled = true,
		singleLine = true,
		textStyle = textStyle,
		keyboardOptions = KeyboardOptions(
			imeAction = ImeAction.Done,
			keyboardType = KeyboardType.Text
		),
		decorationBox = { innerTextField ->
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = modifier
					.height(MaterialTheme.dimens.textFieldHeight)
					.border(width = 1.dp, shape = shape, color = Natural50)
					.background(color = White, shape = shape)
					.focusRequester(focusRequester)
			) {
				Gap(size = 12.dp)

				Box(
					modifier = Modifier.weight(1F)
				) {
					if (value.isEmpty()) {
						Text(
							text = hint,
							style = textStyle,
							color = hintColor,
						)
					}
					Box(modifier = Modifier.fillMaxWidth()) {
						innerTextField()
					}
				}
				if (trailingIcon != null) {
					Gap(size = 8.dp)
					trailingIcon()
				}
				Gap(size = 12.dp)
			}
		},
	)
}