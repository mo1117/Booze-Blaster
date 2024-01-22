package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.*

import org.junit.Test

class GuessTheThemeTaskTest {

    private val guessTheThemeTask = GuessTheThemeTask(
        player = Player(name = "John"), subTasks = emptyList()
    )

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Guess The Theme", guessTheThemeTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.guessing, guessTheThemeTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(guessTheThemeTask.getCoverDescription().length > 30)
    }
}