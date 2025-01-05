package com.herlangga.university.data.remote

import com.herlangga.university.data.models.UniversityResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
interface UniversityService {

	@GET("search")
	suspend fun getAllSchedule(
		@QueryMap params: Map<String, String?>,
	): ApiResponse<List<UniversityResponse>>

}