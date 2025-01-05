package com.herlangga.core.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.herlangga.core.base.SnackBarState
import com.herlangga.core.domain.model.UiText
import com.herlangga.core.domain.model.ViewState

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun MultiStateView(
	state: ViewState,
	loadingLayout: @Composable () -> Unit,
	content: @Composable () -> Unit,
	modifier: Modifier = Modifier,
	errorLayout: @Composable ((String) -> Unit)? = null,
	emptyLayout: @Composable (() -> Unit)? = null,
	idleLayout: @Composable (() -> Unit)? = null,
) {
	Box(modifier = modifier) {
		AnimatedContent(targetState = state, label = "MultiStateView") { state ->
			when (state) {
				is ViewState.Content -> content()
				is ViewState.Empty -> emptyLayout?.invoke()
				is ViewState.Error -> {
					SnackBarState.showErrorSnackBar(UiText.DynamicString(state.message))
					errorLayout?.invoke(state.message)
				}
				is ViewState.Idle -> idleLayout?.invoke()
				is ViewState.Loading -> loadingLayout()
			}
		}
	}
}