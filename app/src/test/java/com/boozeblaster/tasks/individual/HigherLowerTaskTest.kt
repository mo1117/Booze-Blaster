package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.*

import org.junit.Test

class HigherLowerTaskTest {

    private val higherLowerTask =
        HigherLowerTask(player = Player(name = "John"), subTasks = emptyList())

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Higher / Lower", higherLowerTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.higher_lower, higherLowerTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(higherLowerTask.getCoverDescription().length > 30)
    }
}