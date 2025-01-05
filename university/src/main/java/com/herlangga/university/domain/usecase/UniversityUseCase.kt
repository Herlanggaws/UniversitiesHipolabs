package com.herlangga.university.domain.usecase

import com.herlangga.core.domain.model.UseCase
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.UniversityRepository
import com.herlangga.university.domain.model.University
import com.shoolryde.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityUseCase @Inject constructor(
	private val universityRepository: UniversityRepository,
	private val cacheUseCase: UniversityPrefCacheUseCase
) {
	suspend fun invoke(param: UniversityQueryParams): Flow<Resource<List<University>>> {
		val cache = cacheUseCase.getUniversityList(param.name.orEmpty())
		return if (cache == null) {
			getAllUniversityFromNetwork(param)
		} else {
			val isExpired = cacheUseCase.isExpired()
			if (isExpired) getAllUniversityFromNetwork(param)
			else flowOf(Resource.Success(cache))
		}
	}

	private fun getAllUniversityFromNetwork(param: UniversityQueryParams): Flow<Resource<List<University>>> {
		return universityRepository.getAllUniversity(param).onEach {
			if (it is Resource.Success) {
				cacheUseCase.setUniversityList(it.data)
			}
		}
	}
}