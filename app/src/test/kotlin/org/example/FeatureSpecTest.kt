package org.example

import io.kotest.core.spec.style.FeatureSpec

class FeatureSpecTest : FeatureSpec({
    feature("the can of coke") {
        scenario("should be fizzy when I shake it") {
            // test here
        }
        scenario("and should be tasty") {
            // test here
        }
    }
})