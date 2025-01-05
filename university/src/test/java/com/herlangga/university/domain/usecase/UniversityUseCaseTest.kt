package com.herlangga.university.domain.usecase

import app.cash.turbine.test
import com.herlangga.university.data.remote.UniversityQueryParams
import com.herlangga.university.domain.UniversityRepository
import com.herlangga.university.domain.model.University
import com.herlangga.university.test.utils.CoroutineTestRules
import com.shoolryde.core.vo.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class UniversityUseCaseTest {
	@get:Rule
	val coroutineRule = CoroutineTestRules()

	@MockK(relaxed = true)
	private lateinit var repository: UniversityRepository

	@MockK(relaxed = true)
	private lateinit var useCase: UniversityPrefCacheUseCase

	@InjectMockKs
	private lateinit var sut: UniversityUseCase

	@MockK(relaxed = true)
	private lateinit var queryParams: UniversityQueryParams
	private lateinit var mockUniversityList: List<University>

	@Before
	fun setup() {
		MockKAnnotations.init(this)
		mockUniversityList = listOf(mockk(), mockk()) // Add mocked University objects
	}

	@Test
	fun `when cache is null, should fetch data from network and update cache`() = runTest {
		coEvery { useCase.getUniversityList(any()) } returns null
		coEvery { useCase.isExpired() } returns false
		coEvery { repository.getAllUniversity(any()) } returns flowOf(Resource.Success(mockUniversityList))

		sut.invoke(queryParams).test {
			coVerify { repository.getAllUniversity(any()) }
			coVerify { useCase.setUniversityList(mockUniversityList) }
			assertEquals(Resource.Success(mockUniversityList), expectMostRecentItem())
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when cache is expired, should fetch data from network and update cache`() = runTest {
		coEvery { useCase.getUniversityList(any()) } returns mockUniversityList
		coEvery { useCase.isExpired() } returns true // Mark cache as expired
		coEvery { repository.getAllUniversity(any()) } returns flowOf(Resource.Success(mockUniversityList))

		sut.invoke(queryParams).test {
			coVerify { repository.getAllUniversity(any()) }
			coVerify { useCase.setUniversityList(mockUniversityList) }
			assertEquals(Resource.Success(mockUniversityList), expectMostRecentItem())
			cancelAndIgnoreRemainingEvents()
		}
	}

	@Test
	fun `when cache is valid, should return cached data`() = runTest {
		coEvery { useCase.getUniversityList(any()) } returns mockUniversityList
		coEvery { useCase.isExpired() } returns false

		sut.invoke(queryParams).test {
			coVerify(exactly = 0) { repository.getAllUniversity(any()) }
			assertEquals(Resource.Success(mockUniversityList), expectMostRecentItem())
			cancelAndIgnoreRemainingEvents()
		}
	}
}