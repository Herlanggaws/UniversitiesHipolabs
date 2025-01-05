package com.herlangga.university.data.remote

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class UniversityQueryParams(
	val name: String?,
	val limit: String?
) {
	fun getQueryParams(): MutableMap<String, String?> {
		val queryParams = mutableMapOf<String, String?>().apply {
			put("country", "indonesia")
			if (!name.isNullOrBlank()) put("name", name)
			if (!name.isNullOrBlank()) put("limit", limit)
		}
		return queryParams
	}
}
