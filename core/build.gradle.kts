plugins {
	id("org.conventions.lib")
	id("org.conventions.compose")
	id("org.conventions.hilt")
	alias(libs.plugins.kotlin.serialization)
}

android {
	namespace = "com.herlangga.core"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	implementation(libs.androidx.compose.navigation)
}