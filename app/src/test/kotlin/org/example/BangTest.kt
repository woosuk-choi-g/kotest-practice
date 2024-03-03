package org.example

import io.kotest.core.spec.style.StringSpec

class BangTest : StringSpec({
    "!test 1" {
        // this will be ignored
    }

    "test 2" {
        // this will be executed
    }

    "test 3" {
        // this will run too
    }
})