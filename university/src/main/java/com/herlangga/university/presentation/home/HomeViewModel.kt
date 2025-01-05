package com.herlangga.university.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.usecase.UniversityUseCase
import com.shoolryde.core.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
	private val universityUseCase: UniversityUseCase
) : ViewModel() {
	fun getAllUniversity(universityQueryParams: UniversityQueryParams) {
		universityUseCase.invoke(universityQueryParams).onEach { result ->
			when (result) {
				is Resource.Error -> {}
				is Resource.Loading -> {}
				is Resource.Success -> {
				}
			}
		}.launchIn(viewModelScope)
	}
}