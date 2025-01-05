package org.conventions

import org.conventions.utils.addTestLib
import org.conventions.utils.applyKotlinPlugins
import org.conventions.utils.applyKspPlugins
import org.conventions.utils.applyPluginsWithLog
import org.conventions.utils.libs
import org.conventions.utils.testImplementationWithLog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import kotlin.jvm.optionals.getOrNull

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class AndroidLibConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			with(pluginManager) {
				applyPluginsWithLog("com.android.library")
				applyKotlinPlugins()
				applyKspPlugins()
				applyPluginsWithLog("org.conventions.target")
			}
			addTestLib()
		}
	}
}
