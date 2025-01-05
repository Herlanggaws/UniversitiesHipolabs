package com.herlangga.universitieshipolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.herlangga.core.ui.theme.UniversitiesHipolabsTheme
import com.herlangga.universitieshipolabs.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			UniversitiesHipolabsTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					val navController = rememberNavController()
					AppNavigation(
						navController = navController,
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding),
					)
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	UniversitiesHipolabsTheme {
		Greeting("Android")
	}
}