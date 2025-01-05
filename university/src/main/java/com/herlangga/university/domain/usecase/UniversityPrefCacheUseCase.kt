package com.herlangga.university.domain.usecase

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.herlangga.core.domain.repository.PreferencesRepository
import com.herlangga.university.domain.model.University

import java.time.Instant
import java.time.temporal.ChronoUnit
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 06/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityPrefCacheUseCase @Inject constructor(
	private val preferencesRepository: PreferencesRepository,
	private val gson: Gson
) {
	suspend fun setUniversityList(universityList: List<University>) = runCatching {
		val json = gson.toJson(universityList)
		preferencesRepository.setString(CACHE_KEY, json)
		val ttl = Instant.now().plus(CACHE_LIVE_TIME_IN_HOURS, ChronoUnit.HOURS)
		preferencesRepository.setLong(TTL_KEY, ttl.toEpochMilli())
	}.onFailure {
		Log.i("PREF", it.message.orEmpty())
	}

	suspend fun getUniversityList(name: String): List<University>? = runCatching {
		val json = preferencesRepository.getString(CACHE_KEY)
		val temp = when {
			json.isNullOrEmpty() -> {
				Log.e(TAG, "Profile details not found in preferences")
				null
			}

			else -> runCatching {
				val type = object : TypeToken<List<University>>() {}.type
				gson.fromJson<List<University>>(json, type)
			}.getOrElse { exception ->
				Log.e(TAG, "Failed to parse profile details: ${exception.message}", exception)
				preferencesRepository.removeString(CACHE_KEY)
				null
			}
		}
		val result = if (name.isEmpty()) temp else temp?.filter { it.name.contains(name, ignoreCase = true) }

		return result
	}.onFailure {
		preferencesRepository.removeString(CACHE_KEY)
		Log.e(TAG, it.message.orEmpty())
	}.getOrNull()

	suspend fun isExpired(): Boolean {
		val ttl = preferencesRepository.getLong(TTL_KEY)
		if (ttl == null) {
			Log.e(TAG, "Profile detail time to live not found on preferences")
			return true
		}
		val time = Instant.ofEpochMilli(ttl)
		return Instant.now().isAfter(time)
	}

	suspend fun clear() {
		preferencesRepository.removeLong(TTL_KEY)
		preferencesRepository.removeString(CACHE_KEY)
	}

	companion object {
		private const val TAG = "PrefCache"
		private const val CACHE_KEY = "universities_cache"
		private const val TTL_KEY = "universities_cache_ttl"
		private const val CACHE_LIVE_TIME_IN_HOURS = 2L
	}
}