package org.example

import io.kotest.core.spec.style.StringSpec

class FocusExample : StringSpec({
    "test 1" {
        // this will be skipped
    }

    "f:test 2" {
        // this will be executed
    }

    "test 3" {
        // this will be skipped
    }
})