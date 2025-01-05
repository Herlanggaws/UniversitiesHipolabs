package com.herlangga.university.domain.model

import com.herlangga.university.data.models.UniversityResponse
import com.squareup.moshi.Json

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class University(
	val country: String,
	val domain: String,
	val name: String,
	val webPage: String
) {
	constructor(data: UniversityResponse?) : this(
		country = data?.country.orEmpty(),
		domain = data?.domain.orEmpty(),
		name = data?.name.orEmpty(),
		webPage = data?.webPage.orEmpty(),
	)
}
