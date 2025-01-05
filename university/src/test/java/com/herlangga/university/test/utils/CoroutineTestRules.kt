package com.herlangga.university.test.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
class CoroutineTestRules : TestWatcher() {

	private val dispatcher = UnconfinedTestDispatcher()

	override fun starting(description: Description?) {
		super.starting(description)
		Dispatchers.setMain(dispatcher)
	}

	override fun finished(description: Description?) {
		super.finished(description)
		Dispatchers.resetMain()
	}
}