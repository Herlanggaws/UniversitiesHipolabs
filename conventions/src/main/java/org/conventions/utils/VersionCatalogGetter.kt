package org.conventions.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
val Project.libs
	get(): VersionCatalog = getVersionCatalogByName("libs")

private fun Project.getVersionCatalogByName(name: String): VersionCatalog {
	return runCatching {
		extensions.getByType<VersionCatalogsExtension>().named(name)
	}.getOrElse {
		printMessage("Cannot find version catalog named: $name")
		printMessage("please add version catalog on your setting.gradle.kts first")
		throw it
	}
}