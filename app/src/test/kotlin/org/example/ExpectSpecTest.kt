package org.example

import io.kotest.core.spec.style.ExpectSpec

class ExpectSpecTest : ExpectSpec({
    expect("my test") {
        // test here
    }

    context("a calculator") {
        expect("simple addition") {
            // test here
        }
        expect("integer overflow") {
            // test here
        }
    }
})