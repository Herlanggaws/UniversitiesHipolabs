package com.herlangga.university.presentation.home

import app.cash.turbine.test
import com.herlangga.core.domain.model.ViewState
import com.herlangga.university.domain.model.University
import com.herlangga.university.domain.usecase.UniversityUseCase
import com.herlangga.university.test.utils.CoroutineTestRules
import com.shoolryde.core.vo.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
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
		coEvery { useCase.invoke(any()) } returns useCaseResourceEmitter
	}

	@Test
	fun `when getAllUniversities first call should update uistate to loading`() = runTest {
		sut.uiState.test {
			sut.getAllUniversity(mockk())
			coVerify { useCase.invoke(any()) }
			assertEquals(ViewState.Loading, expectMostRecentItem().viewState)
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when getAllUniversities first call should update uistate to content`() = runTest {
		sut.uiState.test {
			sut.getAllUniversity(mockk())
			coVerify { useCase.invoke(any()) }
			useCaseResourceEmitter.emit(Resource.Success(listOf(mockk(), mockk())))
			assertEquals(ViewState.Content, expectMostRecentItem().viewState)
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when getAllUniversities first call should update uistate to empty`() = runTest {
		sut.uiState.test {
			sut.getAllUniversity(mockk())
			coVerify { useCase.invoke(any()) }
			useCaseResourceEmitter.emit(Resource.Success(emptyList()))
			assertEquals(ViewState.Empty, expectMostRecentItem().viewState)
			cancelAndIgnoreRemainingEvents()
		}
	}
}