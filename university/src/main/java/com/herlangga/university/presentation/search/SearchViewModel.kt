package com.herlangga.university.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herlangga.core.domain.model.ViewState
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.usecase.UniversityUseCase
import com.shoolryde.core.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Designed and developed by Herlangga Wicaksono on 06/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
	private val universityUseCase: UniversityUseCase
) : ViewModel() {
	private val _uiEvent = Channel<SearchEvent>()

	val uiEvent get() = _uiEvent.receiveAsFlow()

	private val _uiState = MutableStateFlow(SearchUIState())
	val uiState = _uiState.asStateFlow()

	fun onEvent(event: SearchEvent) = viewModelScope.launch {
		when (event) {
			is SearchEvent.OnSearch -> {
				_uiState.update { it.copy(query = event.query) }
				getAllUniversity(UniversityQueryParams(name = event.query, ""))
			}

			else -> {
				_uiEvent.send(event)
			}
		}
	}

	fun getAllUniversity(universityQueryParams: UniversityQueryParams) = viewModelScope.launch {
		universityUseCase.invoke(universityQueryParams).collect { result ->
			when (result) {
				is Resource.Error -> {
					_uiState.update { it.copy(viewState = ViewState.Error(result.message)) }
				}

				is Resource.Loading -> {
					_uiState.update { it.copy(viewState = ViewState.Loading) }
				}

				is Resource.Success -> {
					_uiState.update {
						it.copy(
							viewState = if (result.data.isEmpty()) ViewState.Empty else ViewState.Content,
							universityList = result.data
						)
					}
				}
			}
		}
	}
}