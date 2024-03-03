package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.testCoroutineScheduler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.days

@OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
class TestDispatcherTest: FunSpec() {
    init {
        test("advance time").config(coroutineTestScope = true) {
            val duration = 1.days

            launch {
                delay(duration.inWholeMilliseconds)
            }

            testCoroutineScheduler.advanceTimeBy(duration.inWholeMilliseconds)
            val currentTime = testCoroutineScheduler.currentTime
            println(currentTime)
        }
    }
}