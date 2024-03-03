package org.example

import io.kotest.core.spec.style.BehaviorSpec

class BehaviorSpecTest : BehaviorSpec({
    given("a broomstick") {
        `when`("I sit on it") {
            then("I should be able to fly") {
                // test here
            }
        }
        `when`("I throw it away") {
            then("it should come back") {
                // test code
            }
        }
    }

    given("a broomstick alter") {
        and("a witch") {
            `when`("the witch sits on it") {
                and("she laughs hysterically") {
                    then("She should be able to fly") {
                        // test code
                    }
                }
            }
        }
    }
})