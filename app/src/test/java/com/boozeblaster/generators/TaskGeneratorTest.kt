package com.boozeblaster.generators

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.utils.GameSettings
import org.junit.Assert.*
import org.junit.Test
import java.lang.reflect.Field

/**
 * Tests for the [TaskGenerator] class
 */
class TaskGeneratorTest {

    val players = listOf(Player(name = "John"), Player(name = "Mary"), Player(name = "Hans"))

    @Test
    fun testGenerateTasks() {
        val tasks = TaskGenerator.generateTasks(players = players, rounds = 3)
        assertNotNull(tasks)
    }

}