package com.herlangga.university.domain

import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.model.University
import com.shoolryde.core.vo.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
interface UniversityRepository {
	fun getAllUniversity(request: UniversityQueryParams): Flow<Resource<List<University>>>
}