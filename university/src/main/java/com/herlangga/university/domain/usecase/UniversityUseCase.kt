package com.herlangga.university.domain.usecase

import com.herlangga.core.domain.model.UseCase
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.UniversityRepository
import com.herlangga.university.domain.model.University
import com.shoolryde.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityUseCase @Inject constructor(
	private val universityRepository: UniversityRepository
) : UseCase<UniversityQueryParams, Flow<Resource<List<University>>>> {
	override fun invoke(param: UniversityQueryParams): Flow<Resource<List<University>>> {
		return universityRepository.getAllUniversity(param)
	}
}