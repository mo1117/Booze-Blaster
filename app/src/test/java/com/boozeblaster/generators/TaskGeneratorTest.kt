package com.boozeblaster.generators

import com.boozeblaster.utils.GameSettings
import org.junit.Assert.*
import org.junit.Test
import java.lang.reflect.Field

/**
 * Tests for the [TaskGenerator] class
 */
class TaskGeneratorTest {

//    private val INDIVIDUAL_TASKS = arrayOf("GuessTheLyrics", "FactOrFiction", "GuessTheSong")
//    private val COMMON_TASKS =
//        arrayOf("HighestBidder", "NeverHaveIEver", "SetRule", "WhoInThisRoom")
//    private val VERSUS_TASKS = arrayOf("RockPaperScissor", "SingASong")
//
//    @Test
//    fun testContainsIndividualTasks() {
//        val individualTasks = getTasksField(type = "individualTasks")
//        assertTrue(
//            individualTasks.get(this) is Array<*>
//                    && (individualTasks.get(this) as Array<*>).isArrayOf<String>()
//        )
//    }
//
//    @Test
//    fun testIndividualTasksAreComplete1() {
//        try {
//            assertEquals(
//                "There should be three individual tasks available by default.",
//                3, getTasksFieldAsArray(type = "INDIVIDUAL_TASKS").size
//            )
//        } catch (e: ClassCastException) {
//            fail(
//                "Could not cast the field INDIVIDUAL_TASKS to an Array of type String. " +
//                        "Something is wrong!"
//            )
//        }
//    }
//
//    @Test
//    fun testIndividualTasksAreComplete2() {
//        try {
//            for (task in INDIVIDUAL_TASKS) {
//                if (!containsTask(task = task, type = "INDIVIDUAL_TASKS")) {
//                    fail("Task $task could not be found in the generator. Make sure it is included.")
//                }
//            }
//        } catch (e: ClassCastException) {
//            fail(
//                "Could not cast the field INDIVIDUAL_TASKS to an Array of type String. " +
//                        "Something is wrong!"
//            )
//        }
//    }
//
//    @Test
//    fun testContainsCommonTasks() {
//        val commonTasks = getTasksField(type = "COMMON_TASKS")
//        assertTrue(
//            commonTasks.get(this) is Array<*>
//                    && (commonTasks.get(this) as Array<*>).isArrayOf<String>()
//        )
//    }
//
//    @Test
//    fun testCommonTasksAreComplete1() {
//        try {
//            assertEquals(
//                "There should be four individual tasks available by default.",
//                4, getTasksFieldAsArray(type = "COMMON_TASKS").size
//            )
//        } catch (e: ClassCastException) {
//            fail(
//                "Could not cast the field COMMON_TASKS to an Array of type String. " +
//                        "Something is wrong!"
//            )
//        }
//    }
//
//    @Test
//    fun testCommonTasksAreComplete2() {
//        try {
//            for (task in COMMON_TASKS) {
//                if (!containsTask(task = task, type = "COMMON_TASKS")) {
//                    fail("Task $task could not be found in the generator. Make sure it is included.")
//                }
//            }
//        } catch (e: ClassCastException) {
//            fail(
//                "Could not cast the field INDIVIDUAL_TASKS to an Array of type String. " +
//                        "Something is wrong!"
//            )
//        }
//    }

    private fun getTasksField(type: String): Field {
        val tasks = GameSettings.javaClass.getDeclaredField(type)
        tasks.isAccessible = true
        return tasks
    }

    @Suppress("UNCHECKED_CAST")
    private fun getTasksFieldAsArray(type: String): Array<String> {
        val individualTask = getTasksField(type = type)
        return individualTask.get(this) as Array<String>
    }

    /**
     * @param task Name of the task
     * @param type Name of the type of task (Individual, Common, Versus)
     * @return True if the task can be found within the list of tasks, false else
     */
    private fun containsTask(task: String, type: String): Boolean {
        return getTasksFieldAsArray(type = type).contains(element = task)
    }

}