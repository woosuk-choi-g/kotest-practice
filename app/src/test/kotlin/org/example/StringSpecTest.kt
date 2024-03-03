package org.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecTest : StringSpec({
    "strings.length should return seize of stirng" {
        "hello".length shouldBe 5
    }

    "strings.length should return size of string".config(enabled = false, invocations = 3) {
        "hello".length shouldBe 5
    }
})