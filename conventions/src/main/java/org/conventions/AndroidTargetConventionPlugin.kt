package org.conventions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.conventions.utils.getJavaVersion
import org.conventions.utils.isApp
import org.conventions.utils.isAppOrLib
import org.conventions.utils.isLib
import org.conventions.utils.libs
import org.conventions.utils.printMessage
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class AndroidTargetConventionPlugin : Plugin<Project> {
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
				val targetSdk = libs.findVersion("sdk-target").get().toString().toInt()
				val minSdkVersion = libs.findVersion("sdk-min").get().toString().toInt()
				if (this is ApplicationExtension) {
					defaultConfig.targetSdk = targetSdk
				}
				compileSdk = libs.findVersion("sdk-compile").get().toString().toInt()
				defaultConfig {
					minSdk = minSdkVersion
				}
				printMessage("Setting up target android sdk to: $targetSdk")
				printMessage("Setting up min android sdk to: $minSdkVersion")
				val javaVersion = getJavaVersion()
				compileOptions {
					sourceCompatibility = javaVersion
					targetCompatibility = javaVersion
				}
				tasks.withType<KotlinCompile>().configureEach {
					kotlinOptions {
						jvmTarget = javaVersion.majorVersion
						val warningsAsErrors: String? by project
						allWarningsAsErrors = warningsAsErrors.toBoolean()
						freeCompilerArgs = freeCompilerArgs +
								listOf(
									"-opt-in=kotlin.RequiresOptIn",
									"-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
									"-opt-in=kotlinx.coroutines.FlowPreview",
								)
					}
				}
			}
		}
	}
}
