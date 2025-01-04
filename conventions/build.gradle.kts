plugins {
	`java-gradle-plugin`
	`kotlin-dsl`
	alias(libs.plugins.ksp)
}

dependencies {
	compileOnly(libs.plugin.agp)
	compileOnly(libs.plugin.kgp)
	compileOnly(libs.plugin.ksp)
	compileOnly(libs.plugin.compose)
}

gradlePlugin {
	val androidTarget by plugins.creating {
		id = "org.conventions.target"
		implementationClass = "org.conventions.AndroidTargetConventionPlugin"
	}
	val app by plugins.creating {
		id = "org.conventions.app"
		implementationClass = "org.conventions.AndroidAppConventionPlugin"
	}
	val lib by plugins.creating {
		id = "org.conventions.lib"
		implementationClass = "org.conventions.AndroidLibConventionPlugin"
	}
	val compose by plugins.creating {
		id = "org.conventions.compose"
		implementationClass = "org.conventions.AndroidComposeConventionPlugin"
	}
	val hilt by plugins.creating {
		id = "org.conventions.hilt"
		implementationClass = "org.conventions.AndroidHiltConventionPlugin"
	}

}