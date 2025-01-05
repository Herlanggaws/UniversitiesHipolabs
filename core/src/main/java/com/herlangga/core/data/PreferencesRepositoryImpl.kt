package com.herlangga.core.data

import com.herlangga.core.domain.repository.PreferencesRepository
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 06/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class PreferencesRepositoryImpl @Inject constructor(
	private val dataStore: DataStore<Preferences>
) : PreferencesRepository {
	override suspend fun getString(key: String): String? {
		return dataStore.data.map { it[stringPreferencesKey(key)] }.first()
	}

	override suspend fun setString(key: String, value: String) {
		dataStore.edit { it[stringPreferencesKey(key)] = value }
	}

	override suspend fun removeString(vararg key: String) {
		dataStore.edit { pref ->
			key.forEach {
				pref.remove(stringPreferencesKey(it))
			}
		}
	}

	override suspend fun getBoolean(key: String): Boolean? {
		return dataStore.data.map { it[booleanPreferencesKey(key)] }.first()
	}

	override suspend fun setBoolean(key: String, value: Boolean) {
		dataStore.edit { it[booleanPreferencesKey(key)] = value }
	}

	override suspend fun removeBoolean(vararg key: String) {
		dataStore.edit { pref ->
			key.forEach {
				pref.remove(booleanPreferencesKey(it))
			}
		}
	}

	override suspend fun getLong(key: String): Long? {
		return dataStore.data.map { it[longPreferencesKey(key)] }.first()
	}

	override suspend fun setLong(key: String, value: Long) {
		dataStore.edit { it[longPreferencesKey(key)] = value }
	}

	override suspend fun removeLong(vararg key: String) {
		dataStore.edit { pref ->
			key.forEach {
				pref.remove(longPreferencesKey(it))
			}
		}
	}

	override suspend fun clear() {
		dataStore.edit { it.clear() }
	}
}