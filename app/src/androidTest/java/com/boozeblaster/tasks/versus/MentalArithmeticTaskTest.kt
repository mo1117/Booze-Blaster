package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MentalArithmeticTaskTest {

    private val mentalArithmeticTask = MentalArithmeticTask(
        player = Player(name = "John"),
        subTasks = emptyList(),
        versusPlayer = Player(name = "Mary")
    )

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Mental Arithmetic", mentalArithmeticTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.calculating, mentalArithmeticTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(mentalArithmeticTask.getCoverDescription().length > 30)
    }
}