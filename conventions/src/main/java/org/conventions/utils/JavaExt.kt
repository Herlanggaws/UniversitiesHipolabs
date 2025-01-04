package org.conventions.utils

import org.gradle.api.JavaVersion
import org.gradle.api.Project

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun Project.getJavaVersion(): JavaVersion {
	val jvmTargetVersion = libs.findVersion("jvm-target").get().toString()
	return JavaVersion.toVersion(jvmTargetVersion).also {
		printMessage("Setting up JDK to: $it")
	}
}