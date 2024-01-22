package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.*

import org.junit.Test

class GuessTheSongTaskTest {

    private val guessTheSongTask = GuessTheSongTask(
        player = Player(name = "John"), subTasks = emptyList()
    )

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Guess The Song", guessTheSongTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.guessing, guessTheSongTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(guessTheSongTask.getCoverDescription().length > 30)
    }
}