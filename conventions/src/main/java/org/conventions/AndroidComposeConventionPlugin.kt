package org.conventions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.conventions.utils.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class AndroidComposeConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			if (!isAppOrLib()) return@with
			val type =
				when {
					isApp() -> ApplicationExtension::class
					isLib() -> LibraryExtension::class
					else -> null
				} ?: return@with
			the(type).apply {
				buildFeatures {
					compose = true
				}
				the(KspExtension::class).apply {
					arg("compose-destinations.mode", "destinations")
					arg("compose-destinations.useComposableVisibility", "true")
				}
				composeOptions {
					val compileVersion = libs.findVersion("compose-compiler").get().toString()
					kotlinCompilerExtensionVersion = compileVersion
				}
			}

			dependencies {
				findLibs("compose-bom")?.let { implementationPlatformWithLog(it) }
				findLibs("compose-bom")?.let { androidTestImplementationPlatformWithLog(it) }
				findLibs("compose-activity")?.let { implementationWithLog(it) }
				findLibs("compose-ui")?.let { implementationWithLog(it) }
				findLibs("compose-material")?.let { implementationWithLog(it) }
				findLibs("compose-ui-graphics")?.let { implementationWithLog(it) }
				findLibs("compose-ui-preview")?.let { implementationWithLog(it) }
				findLibs("compose-destination")?.let { implementationWithLog(it) }
				findLibs("compose-destination-ksp")?.let { kspWithLog(it) }
				findLibs("compose-navigation")?.let { implementationWithLog(it) }
				findLibs("compose-icons-extended")?.let { implementationWithLog(it) }
				findLibs("compose-lifecycle-viewmodel")?.let { implementationWithLog(it) }
				findLibs("compose-lifecycle-runtime")?.let { implementationWithLog(it) }
				findLibs("compose-lottie")?.let { implementationWithLog(it) }
				findLibs("compose-foundation")?.let { implementationWithLog(it) }
				findLibs("compose-paging")?.let { implementationWithLog(it) }
				findLibs("compose-ui-tooling")?.let { debugImplementationWithLog(it) }
				findLibs("compose-ui-manifest")?.let { debugImplementationWithLog(it) }
				findLibs("compose-test-junit")?.let { androidTestImplementationWithLog(it) }
			}
		}
	}
}
