package com.herlangga.university.di

import com.herlangga.university.data.UniversityRepositoryImpl
import com.herlangga.university.domain.UniversityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class UniversityRepositoryModule {
	@Binds
	@Singleton
	abstract fun bindUniversityRepository(universityRepositoryImpl: UniversityRepositoryImpl): UniversityRepository
}