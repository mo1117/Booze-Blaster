package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.*

import org.junit.Test

class GuessTheLyricsTaskTest {

    private val guessTheLyricsTask = GuessTheLyricsTask(
        player = Player(name = "John"), subTasks = emptyList()
    )

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Guess The Lyrics", guessTheLyricsTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.lyrics, guessTheLyricsTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(guessTheLyricsTask.getCoverDescription().length > 30)
    }
}