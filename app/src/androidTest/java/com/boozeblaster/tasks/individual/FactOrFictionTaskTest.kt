package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.models.Player
import org.junit.Assert.*

import org.junit.Test

class FactOrFictionTaskTest {

    private val factOrFictionTask = FactOrFictionTask(
        player = Player(name = "John"), subTasks = emptyList()
    )

    @Test
    fun testDisplayCorrectName() {
        assertEquals("Fact Or Fiction", factOrFictionTask.getName())
    }

    @Test
    fun testDisplayCorrectImage() {
        assertEquals(R.drawable.fact_or_fiction, factOrFictionTask.getImageId())
    }

    @Test
    fun testDisplayCoverDescription() {
        assertTrue(factOrFictionTask.getCoverDescription().length > 30)
    }
}