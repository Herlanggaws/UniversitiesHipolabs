import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
	id("org.conventions.lib")
	id("org.conventions.compose")
	id("org.conventions.hilt")
	alias(libs.plugins.kotlin.serialization)
}

val properties = gradleLocalProperties(rootDir, providers)

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
		debug {
			buildConfigField("String", "BASE_URL", "\"http://universities.hipolabs.com/\"")
		}
	}

	buildFeatures {
		buildConfig = true
	}
	ksp {
		arg("room.schemaLocation", "$projectDir/schemas")
	}
}

dependencies {
	api(libs.coil)
	api(libs.bundles.networking)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	implementation(libs.androidx.compose.navigation)

	debugImplementation(libs.chucker)
	releaseImplementation(libs.chucker.no.op)

	implementation(libs.datastore)
	implementation(libs.datastore.core)

	api(libs.bundles.moshi)
	ksp(libs.moshi.codegen)

	api(libs.bundles.json)
	api(libs.retrofit.gson)
}