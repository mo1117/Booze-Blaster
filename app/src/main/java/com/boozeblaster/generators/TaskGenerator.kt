package com.boozeblaster.generators

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.common.SipTransferTask
import kotlin.random.Random

/**
 * This object handles generating tasks based on the amount of players and the number of rounds
 * that are to be played for a game of BoozeBlaster
 *
 * By generating different common and individual tasks and assigning them to players,
 * if needed, a list of tasks that will then be played can be created
 */
object TaskGenerator {

    private val INDIVIDUAL_TASKS = arrayOf(/*"GuessTheLyrics", "FactOrFiction"*/"GuessTheSong")
    private val COMMON_TASKS = arrayOf("NeverHaveIEver", "WhoInThisRoom", "SetRule")

    fun generateTasks(players: List<Player>, rounds: Int): List<Task> {
        var tasks = listOf<Task>()
        for (round in 0 until rounds) {
            tasks = tasks.plus(element = generateCommonTask(isLastRound = rounds - round == 1))
            for (i in players.indices) {
                tasks =
                    tasks.plus(element = generateIndividualTask(player = players.get(index = i)))
            }
        }
        return tasks
    }

    /**
     * This method generates a random individual task and assigns it to a player
     *
     * First, we generate a random index and take the string from the array INDIVIDUAL_TASKS
     *
     * Then, get the constructor of the class for the specific Task, and an instance of the matching
     * generator with its getList() method
     *
     * We return a new instance of the given Task and initialize it with the passed argument Player
     * and the return value of the getList() method
     * @param player Player
     * @return IndividualTask (specific individual task)
     */
    private fun generateIndividualTask(player: Player): IndividualTask {
        val random = Random.nextInt(from = 0, until = INDIVIDUAL_TASKS.size)
        val game = INDIVIDUAL_TASKS[random]

        val constructor = Class.forName("com.boozeblaster.tasks.individual.${game}Task")
            .getConstructor(Player::class.java, List::class.java)

        val instance = Class.forName("com.boozeblaster.generators.individual.${game}Generator")
            .newInstance()
        val generator = Class.forName("com.boozeblaster.generators.individual.${game}Generator")
            .getMethod("getList")

        return constructor.newInstance(player, generator.invoke(instance)) as IndividualTask
    }

    /**
     * Works similar to generateIndividualTask
     * @param isLastRound Whether we are in the last round
     * @return CommonTask (Specific common task) - Or a SipTransferTask if we are in the last round
     * @see TaskGenerator.generateIndividualTask
     */
    private fun generateCommonTask(isLastRound: Boolean): CommonTask {
        if (isLastRound) {
            return SipTransferTask(subTasks = emptyList())
        }
        val random = Random.nextInt(from = 0, until = COMMON_TASKS.size)
        val game = COMMON_TASKS[random]

        val constructor = Class.forName("com.boozeblaster.tasks.common.${game}Task")
            .getConstructor(List::class.java)

        val instance = Class.forName("com.boozeblaster.generators.common.${game}Generator")
            .newInstance()
        val generator = Class.forName("com.boozeblaster.generators.common.${game}Generator")
            .getMethod("getList")

        return constructor.newInstance(generator.invoke(instance)) as CommonTask
    }
}