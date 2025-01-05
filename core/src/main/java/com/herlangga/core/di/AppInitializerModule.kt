package com.herlangga.core.di

import com.herlangga.core.utils.AppInitializer
import com.herlangga.core.utils.AppInitializers
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppInitializerComponent

@InstallIn(SingletonComponent::class)
@Module
class AppInitializerModule {
	@Provides
	fun provideAppInitializer(
		@AppInitializerComponent initializers: Lazy<Set<@JvmSuppressWildcards AppInitializer>>
	): AppInitializers = AppInitializers(initializers)
}