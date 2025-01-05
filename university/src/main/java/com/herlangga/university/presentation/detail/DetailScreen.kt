package com.herlangga.university.presentation.detail

import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.herlangga.core.components.CustomToolbar
import com.herlangga.core.ui.theme.White

/**
 * Designed and developed by Herlangga Wicaksono on 04/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Composable
fun DetailScreen(
	navHostController: NavHostController,
	url: String
) {
	var isLoading by remember { mutableStateOf(true) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(White)
	) {
		CustomToolbar(
			title = "",
			onBackPressed = {
				navHostController.navigateUp()
			}
		)
		AndroidView(
			factory = { context ->
				WebView(context).apply {
					webViewClient = object : WebViewClient() {
						override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
							super.onPageStarted(view, url, favicon)
							isLoading = true
						}

						override fun onPageFinished(view: WebView?, url: String?) {
							super.onPageFinished(view, url)
							isLoading = false
						}

						override fun onReceivedError(
							view: WebView?,
							request: android.webkit.WebResourceRequest?,
							error: android.webkit.WebResourceError?
						) {
							super.onReceivedError(view, request, error)
							isLoading = false
						}
					}
					settings.javaScriptEnabled = true
					settings.cacheMode = WebSettings.LOAD_DEFAULT // Use default cache mode
				}
			},
			update = { webView ->
				webView.loadUrl(url)
			},
			modifier = Modifier.fillMaxSize()
		)

		// Show a loading spinner while the page is loading
		if (isLoading) {
			CircularProgressIndicator(
				modifier = Modifier
					.padding(16.dp)
			)
		}
	}
}