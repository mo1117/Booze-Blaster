package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.minigames.versus.RockPaperScissors
import com.boozeblaster.models.Player
import org.junit.Assert
import org.junit.Test

class RockPaperScissorsTaskTest {

    private val rockPaperScissorsTask = RockPaperScissorsTask(
        player = Player(name = "John"),
        subTasks = emptyList(),
        versusPlayer = Player(name = "Mary")
    )

    @Test
    fun testDisplayCorrectName() {
        Assert.assertEquals("Rock-Paper-Scissors", rockPaperScissorsTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        Assert.assertEquals(R.drawable.rock_paper_scissors, rockPaperScissorsTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        Assert.assertTrue(rockPaperScissorsTask.getCoverDescription().length > 30)
    }
}