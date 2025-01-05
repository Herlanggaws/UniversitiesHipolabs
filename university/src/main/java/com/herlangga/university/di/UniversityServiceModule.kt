package com.herlangga.university.di

import com.herlangga.university.data.remote.UniversityService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Module
@InstallIn(SingletonComponent::class)
object UniversityServiceModule {
	@Provides
	@Singleton
	fun provideUniversityService(retrofit: Retrofit): UniversityService =
		retrofit.create(UniversityService::class.java)
}