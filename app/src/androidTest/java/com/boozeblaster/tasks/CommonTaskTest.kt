package com.boozeblaster.tasks

import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.reflect.Modifier

class CommonTaskTest {

    @Test
    fun testCommonTaskShouldBeAbstract() {
        assertTrue(Modifier.isAbstract(CommonTask::class.java.modifiers))
    }
}