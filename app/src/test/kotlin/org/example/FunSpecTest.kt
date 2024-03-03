package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FunSpecTest : FunSpec({
    test("String length should return the length of the string") {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }

    context("this outer block is enabled") {
        xtest("this test is disabled") {
            // test here
        }
    }

    xcontext("this block is disabled") {
        test("disabled by inheritance from parent") {
            // test here
        }
    }
})