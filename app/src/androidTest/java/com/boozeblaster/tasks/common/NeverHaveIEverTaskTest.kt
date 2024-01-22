package com.boozeblaster.tasks.common

import com.boozeblaster.R
import org.junit.Assert.*

import org.junit.Test

class NeverHaveIEverTaskTest {

    private val neverHaveIEverTask = NeverHaveIEverTask(subTasks = emptyList())

    @Test
    fun getName() {
        assertEquals("Never Have I Ever", neverHaveIEverTask.getName())
    }

    @Test
    fun getImageId() {
        assertEquals(R.drawable.guessing, neverHaveIEverTask.getImageId())
    }

    @Test
    fun getCoverDescription() {
        assertTrue(neverHaveIEverTask.getCoverDescription().length > 30)
    }
}