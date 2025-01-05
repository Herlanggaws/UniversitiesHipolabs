package com.herlangga.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */

@Module
@InstallIn(SingletonComponent::class)
object GlobalModule {
	@Provides
	fun provideDefaultGson(): Gson {
		return GsonBuilder().create()
	}
}