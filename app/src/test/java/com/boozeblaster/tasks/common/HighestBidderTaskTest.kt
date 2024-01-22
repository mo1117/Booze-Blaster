package com.boozeblaster.tasks.common

import org.junit.Assert.*
import com.boozeblaster.R

import org.junit.Test

class HighestBidderTaskTest {

    private val highestBidderTask = HighestBidderTask(subTasks = emptyList())

    @Test
    fun getName() {
        assertEquals("Highest Bidder", highestBidderTask.getName())
    }

    @Test
    fun getImageId() {
        assertEquals(R.drawable.higher_lower, highestBidderTask.getImageId())
    }

    @Test
    fun getCoverDescription() {
        assertTrue(highestBidderTask.getCoverDescription().length > 30)
    }
}