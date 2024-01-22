package com.boozeblaster.tasks.common

import com.boozeblaster.R
import org.junit.Assert.*

import org.junit.Test

class SetRuleTaskTest {

    private val setRuleTask = SetRuleTask(subTasks = emptyList())

    @Test
    fun getName() {
        assertEquals("Set A Rule", setRuleTask.getName())
    }

    @Test
    fun getImageId() {
        assertEquals(R.drawable.judge_hammer_black, setRuleTask.getImageId())
    }

    @Test
    fun getCoverDescription() {
        assertTrue(setRuleTask.getCoverDescription().length > 30)
    }
}