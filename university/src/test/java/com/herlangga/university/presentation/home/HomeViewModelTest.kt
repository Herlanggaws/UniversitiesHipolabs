package com.herlangga.university.presentation.home

import app.cash.turbine.test
import com.herlangga.core.domain.model.ViewState
import com.herlangga.university.domain.model.University
import com.herlangga.university.domain.usecase.UniversityUseCase
import com.herlangga.university.test.utils.CoroutineTestRules
import com.shoolryde.core.vo.Resource
import io.mockk.MockKAnnotations
import io.mockk.awaits
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class HomeViewModelTest {
	@get:Rule
	val coroutineRule = CoroutineTestRules()

	@MockK(relaxed = true)
	private lateinit var useCase: UniversityUseCase

	@InjectMockKs
	private lateinit var sut: HomeViewModel

	private lateinit var useCaseResourceEmitter: MutableStateFlow<Resource<List<University>>>

	@Before
	fun setup() {
		MockKAnnotations.init(this)
		useCaseResourceEmitter = MutableStateFlow(Resource.Loading)
//		every { useCase.invoke(any()) } returns useCaseResourceEmitter
	}

	@Test
	fun `when getAllUniversities first call should update uistate to loading`() = runTest {
		sut.uiState.test {
			sut.getAllUniversity(mockk())
//			verify { useCase.invoke(any()) }
			assertEquals(ViewState.Loading, expectMostRecentItem().viewState)
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when getAllUniversities first call should update uistate to content`() = runTest {
		sut.uiState.test {
			sut.getAllUniversity(mockk())
//			verify { useCase.invoke(any()) }
			useCaseResourceEmitter.emit(Resource.Success(emptyList()))
			assertEquals(ViewState.Content, expectMostRecentItem().viewState)
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when usecase is returning error resource should trigger navigate up`() = runTest {
		sut.uiEvent.test {
			sut.getAllUniversity(mockk())
			useCaseResourceEmitter.emit(Resource.Error("error"))
			assertEquals(HomeEvent.NavigateUp, awaitItem())
			cancelAndIgnoreRemainingEvents()
		}
	}
}