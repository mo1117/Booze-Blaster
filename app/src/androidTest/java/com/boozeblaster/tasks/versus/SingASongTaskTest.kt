package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert
import org.junit.Test

class SingASongTaskTest {

    private val singASongTask = SingASongTask(
        player = Player(name = "John"),
        subTasks = emptyList(),
        versusPlayer = Player(name = "Mary")
    )

    @Test
    fun testDisplayCorrectName() {
        Assert.assertEquals("Sing A Song", singASongTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        Assert.assertEquals(R.drawable.karaoke, singASongTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        Assert.assertTrue(singASongTask.getCoverDescription().length > 30)
    }
}