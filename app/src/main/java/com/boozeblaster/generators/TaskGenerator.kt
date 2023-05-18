package com.boozeblaster.generators

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.tasks.Task
import kotlin.random.Random

/**
 * This object handles generating tasks based on the amount of players and the number of rounds
 * that are to be played for a game of BoozeBlaster
 *
 * By generating different common and individual tasks and assigning them to players,
 * if needed, a list of tasks that will then be played can be created
 */
object TaskGenerator {

    private val INDIVIDUAL_TASKS = arrayOf("FactOrFiction", "GuessTheLyrics")
    private val COMMON_TASKS = arrayOf<String>()

    fun generateTasks(players: List<Player>, rounds: Int): List<Task> {
        val tasks = listOf<Task>()
        for (round in 0 until rounds) {
            //TODO add common tasks
            for (i in players.indices) {
                //TODO add individual tasks to players
            }
        }
        return tasks
    }

    private fun generateRandomIndividualTask(player: Player): IndividualTask? {
        val random = Random.nextInt(from = 0, until = INDIVIDUAL_TASKS.size)
        val game = INDIVIDUAL_TASKS[random]
        val generator = Class.forName("com.boozeblaster.generators.${game}Generator")
            .getMethod("getList")


        val clazz = Class.forName(game).kotlin
        val method = clazz.java.getConstructor()
        return null
    }
}