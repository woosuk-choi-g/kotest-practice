package org.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.Enabled
import io.kotest.core.test.EnabledIf
import io.kotest.core.test.TestCase
import io.kotest.core.test.config.enabledOrReasonIf
import org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class EnabledFlagTest : StringSpec({
    "enabled false".config(enabled = false) {
        // test here
    }

    "enabled IS_OS_LINUX".config(enabled = IS_OS_LINUX) {
        // test here
    }

    val current = LocalDate.now()

    fun isFriday(): Boolean {
        return current.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()) == "Fri"
    }

    val disabledDangerOnFriday: EnabledIf = { !(it.name.testName.startsWith("danger") && isFriday()) }

    "danger Will Robinson".config(enabledIf = disabledDangerOnFriday) {
        // test here
    }

    "safe Will Robinson".config(enabledIf = disabledDangerOnFriday) {
        // test here
    }

    val disabledDangerOnFridayWithReason: (TestCase) -> Enabled = {
        if (it.name.testName.startsWith("danger") && isFriday()) {
            Enabled.disabled("It's Friday")
        } else {
            Enabled.enabled
        }
    }

    "danger Will Robinson with reason".config(enabledOrReasonIf = disabledDangerOnFridayWithReason) {
        // test here
    }

    "safe Will Robinson with reason".config(enabledOrReasonIf = disabledDangerOnFridayWithReason) {
        // test here
    }
})