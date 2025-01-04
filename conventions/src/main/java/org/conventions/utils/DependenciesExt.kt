package org.conventions.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import kotlin.jvm.optionals.getOrNull

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun DependencyHandlerScope.kaptWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("kapt", notation)
	printMessage("Adding library kapt: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.implementationWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("implementation", notation)
	printMessage("Adding library implementation: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.kspWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("ksp", notation)
	printMessage("Adding ksp implementation: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.implementationPlatformWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("implementation", platform(notation))
	printMessage("Adding platform library implementation: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.androidTestImplementationPlatformWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("androidTestImplementation", platform(notation))
	printMessage("Adding android test platform library implementation: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.androidTestImplementationWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("androidTestImplementation", notation)
	printMessage("Adding android test library implementation: ${notation.orNull?.name}")
}

fun DependencyHandlerScope.debugImplementationWithLog(notation: Provider<MinimalExternalModuleDependency>) {
	add("debugImplementation", notation)
	printMessage("Adding debug library implementation: ${notation.orNull?.name}")
}

fun Project.findLibs(
	alias: String,
	isPrintError: Boolean = false,
): Provider<MinimalExternalModuleDependency>? {
	val dependency = libs.findLibrary(alias).getOrNull()
	if (dependency == null) {
		if (isPrintError) printMessage("Cannot find $alias on buildtools version catalog, please check version")
		return null
	}
	return dependency
}

fun Project.isAliasesExistOnBuildTools(vararg alias: String): Boolean {
	return alias.all {
		val plugin = libs.findPlugin(it).getOrNull()?.orNull?.pluginId
		val lib = libs.findLibrary(it).getOrNull()
		plugin != null || lib != null
	}
}
