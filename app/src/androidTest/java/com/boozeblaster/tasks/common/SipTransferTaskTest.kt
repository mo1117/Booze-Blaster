package com.boozeblaster.tasks.common

import com.boozeblaster.R
import org.junit.Assert.*

import org.junit.Test

class SipTransferTaskTest {

    private val sipTransferTask = SipTransferTask(subTasks = emptyList())

    @Test
    fun getName() {
        assertEquals("Sip Transfer", sipTransferTask.getName())
    }

    @Test
    fun getImageId() {
        assertEquals(R.drawable.handshake, sipTransferTask.getImageId())
    }

    @Test
    fun getCoverDescription() {
        assertTrue(sipTransferTask.getCoverDescription().length > 30)
    }
}