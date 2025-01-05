package com.herlangga.core.utils

import android.app.Application
import dagger.Lazy

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun interface AppInitializer {
	fun init(app: Application)
}

class AppInitializers(
	private val initials: Lazy<Set<AppInitializer>>
) : AppInitializer {

	override fun init(app: Application) {
		initials.get().forEach { it.init(app) }
	}
}