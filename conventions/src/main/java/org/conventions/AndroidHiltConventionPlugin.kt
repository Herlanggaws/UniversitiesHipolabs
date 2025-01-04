package org.conventions

import org.conventions.utils.applyPluginsWithLog
import org.conventions.utils.findLibs
import org.conventions.utils.implementationWithLog
import org.conventions.utils.kspWithLog
import org.conventions.utils.findPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class AndroidHiltConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			with(pluginManager) {
				val hiltPluginId = findPlugin("hilt", true) ?: return
				applyPluginsWithLog(hiltPluginId)
			}
			dependencies {
				findLibs("dagger-hilt")?.let { implementationWithLog(it) }
				findLibs("dagger-hilt-android-compiler")?.let { kspWithLog(it) }
				findLibs("dagger-hilt-compiler")?.let { kspWithLog(it) }
				findLibs("dagger-hilt-compose-navigation")?.let { implementationWithLog(it) }
			}
		}
	}
}
