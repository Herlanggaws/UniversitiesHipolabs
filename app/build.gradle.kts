plugins {
	id("org.conventions.app")
	id("org.conventions.hilt")
	id("org.conventions.compose")
	alias(libs.plugins.kotlin.serialization)
}

android {
	namespace = "com.herlangga.universitieshipolabs"

	defaultConfig {
		applicationId = "com.herlangga.universitieshipolabs"
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
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
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	implementation(project(":core"))
	implementation(project(":university"))
	implementation(libs.androidx.material3.android)
	implementation(libs.androidx.ui.tooling.preview.android)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}