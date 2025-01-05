package com.herlangga.university.data

import android.provider.SyncStateContract
import android.util.Log
import com.herlangga.core.utils.Constants
import com.herlangga.core.utils.getErrorMessage
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.UniversityRepository
import com.herlangga.university.domain.model.University
import com.shoolryde.core.vo.Resource
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityRepositoryImpl @Inject constructor(
	private val remoteDataSource: UniversityDataSource
) : UniversityRepository {
	override fun getAllUniversity(request: UniversityQueryParams): Flow<Resource<List<University>>>  = flow {
		remoteDataSource.getAllSchedule(request.getQueryParams()).let {
			it.suspendOnSuccess {
				Log.i("elang", "elang UniversityRepositoryImpl ${data.first().domain}")
				emit(Resource.Success(data.map { University(it) }))
			}.suspendOnError {
				emit(Resource.Error(getErrorMessage()))
			}.suspendOnException {
				emit(Resource.Error(Constants.DEFAULT_ERROR_MESSAGE))
			}
		}
	}.onStart { emit(Resource.Loading) }.flowOn(Dispatchers.IO)
}