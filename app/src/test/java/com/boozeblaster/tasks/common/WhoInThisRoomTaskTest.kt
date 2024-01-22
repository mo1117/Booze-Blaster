package com.boozeblaster.tasks.common

import com.boozeblaster.R
import org.junit.Assert.*

import org.junit.Test

class WhoInThisRoomTaskTest {

    private val whoInThisRoomTask = WhoInThisRoomTask(subTasks = emptyList())

    @Test
    fun getName() {
        assertEquals("Who In This Room", whoInThisRoomTask.getName())
    }

    @Test
    fun getImageId() {
        assertEquals(R.drawable.guessing, whoInThisRoomTask.getImageId())
    }

    @Test
    fun getCoverDescription() {
        assertTrue(whoInThisRoomTask.getCoverDescription().length > 30)
    }
}