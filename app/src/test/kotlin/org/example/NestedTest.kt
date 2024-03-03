package org.example

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NestedTest : DescribeSpec({
    describe("an outer test") {
        it("an inner test") {
            1 + 2 shouldBe 3
        }

        it("an inner test too!") {
            3 + 4 shouldBe 7
        }
    }
})