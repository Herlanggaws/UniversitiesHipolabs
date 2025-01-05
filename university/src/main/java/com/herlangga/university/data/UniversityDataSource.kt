package com.herlangga.university.data

import com.herlangga.university.data.models.UniversityResponse
import com.herlangga.university.data.remote.UniversityService
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityDataSource @Inject constructor(private val universityService: UniversityService) :
	UniversityService {
	override suspend fun getAllSchedule(params: Map<String, String?>): ApiResponse<List<UniversityResponse>> {
		return universityService.getAllSchedule(params)
	}
}