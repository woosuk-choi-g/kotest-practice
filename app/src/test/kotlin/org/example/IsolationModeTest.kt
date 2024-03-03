package org.example

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.WordSpec
import java.util.concurrent.atomic.AtomicInteger

class IsolationModeTest : WordSpec({
    isolationMode = IsolationMode.SingleInstance
    // tests here
})

class IsolationModeTest2 : WordSpec() {
    override fun isolationMode() = IsolationMode.SingleInstance
    init {
        // tests here
    }
}

class InstancePerTestExample: WordSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    val counter = AtomicInteger(0)

    init {
        "a" should {
            println("a=" + counter.getAndIncrement())
            "b" {
                println("b=" + counter.getAndIncrement())
            }
            "c" {
                println("c=" + counter.getAndIncrement())
            }
        }
    }

//    a=0
//    a=0
//    b=1
//    a=0
//    c=1
}

class InstancePerLeafTestExample: WordSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf

    val counter = AtomicInteger(0)

    init {
        "a" should {
            println("a=" + counter.getAndIncrement())
            "b" {
                println("b=" + counter.getAndIncrement())
            }
            "c" {
                println("c=" + counter.getAndIncrement())
            }
        }
    }

//    a=0
//    b=1
//    a=0
//    c=1
}