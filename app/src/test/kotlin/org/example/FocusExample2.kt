package org.example

import io.kotest.core.spec.style.FunSpec

class FocusExample2 : FunSpec({
    context("test 1") {
        // this will be skipped
        test("foo") {
            // this will be skipped
        }
    }

    context("f:test 2") {
        // this will be executed
        test("foo") {
            // this will be executed
        }
    }

    context("test 3") {
        // this will be skipped
        test("foo") {
            // this will be skipped
        }
    }
})