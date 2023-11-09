package com.boozeblaster

import com.boozeblaster.generators.TaskGenerator
import org.junit.Test
import org.junit.Assert.*
import java.lang.reflect.Field

class TaskGeneratorTest {

    private val INDIVIDUAL_TASKS = arrayOf("GuessTheLyrics", "FactOrFiction", "GuessTheSong")

    @Test
    fun testContainsIndividualTasks1() {
        val individualTasks = getIndividualTasksField()
        assertTrue(
            individualTasks.get(this) is Array<*>
                    && (individualTasks.get(this) as Array<*>).isArrayOf<String>()
        )
    }

    @Test
    fun testContainsIndividualTasks2() {
        try {
            assertEquals(
                "There should be three individual tasks available by default.",
                3, getIndividualTasksFieldAsArray().size
            )
        } catch (e: ClassCastException) {
            fail(
                "Could not cast the field INDIVIDUAL_TASKS to an Array of type String. " +
                        "Something is wrong!"
            )
        }
    }

    @Test
    fun testContainsIndividualTasks3() {
        try {
            for (task in INDIVIDUAL_TASKS) {
                if (!containsIndividualTask(task = task)) {
                    fail("Task $task could not be found. Make sure it is included.")
                }
            }
        } catch (e: ClassCastException) {
            fail(
                "Could not cast the field INDIVIDUAL_TASKS to an Array of type String. " +
                        "Something is wrong!"
            )
        }
    }

    private fun getIndividualTasksField(): Field {
        val individualTask = TaskGenerator.javaClass.getDeclaredField("INDIVIDUAL_TASKS")
        individualTask.isAccessible = true
        return individualTask
    }

    @Suppress("UNCHECKED_CAST")
    private fun getIndividualTasksFieldAsArray(): Array<String> {
        val individualTask = getIndividualTasksField()
        return individualTask.get(this) as Array<String>
    }

    private fun containsIndividualTask(task: String): Boolean {
        return getIndividualTasksFieldAsArray().contains(element = task)
    }

}