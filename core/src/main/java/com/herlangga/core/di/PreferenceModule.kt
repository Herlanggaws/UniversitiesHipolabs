package com.herlangga.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.herlangga.core.data.PreferencesRepositoryImpl
import com.herlangga.core.domain.repository.PreferencesRepository
import com.herlangga.core.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Designed and developed by Herlangga Wicaksono on 06/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {
	@Binds
	@Singleton
	abstract fun bindPrefRepo(impl: PreferencesRepositoryImpl): PreferencesRepository

	companion object {
		private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
			name = Constants.CREDENTIALS
		)

		@Provides
		@Singleton
		fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
			return context.dataStore
		}
	}
}