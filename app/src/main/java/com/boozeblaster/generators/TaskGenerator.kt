package com.boozeblaster.generators

import com.boozeblaster.generators.strategy.CommonTaskGenerationStrategy
import com.boozeblaster.generators.strategy.IndividualTaskGenerationStrategy
import com.boozeblaster.generators.strategy.VersusTaskGenerationStrategy
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.utils.GameSettings
import kotlin.random.Random

private val commonTaskGenerationStrategy = CommonTaskGenerationStrategy()
private val versusTaskGenerationStrategy = VersusTaskGenerationStrategy()
private val individualTaskGenerationStrategy = IndividualTaskGenerationStrategy()

/**
 * This object handles generating tasks based on the amount of players and the number of rounds
 * that are to be played for a game of BoozeBlaster
 *
 * By generating different common, individual, and versus tasks and assigning them to players,
 * if needed, a list of tasks that will then be played can be created
 */
object TaskGenerator {

    fun generateTasks(players: List<Player>, rounds: Int): List<Task> {
        var tasks = listOf<Task>()
        var randomPlayer: Player
        var randomVersusPlayer: Player


        for (round in 0 until rounds) {
            commonTaskGenerationStrategy.generateTask(
                rounds - round == 1 && rounds > 1 && GameSettings.playSipTransfer(), null, null, tasks)

            randomPlayer = players.get(index = Random.nextInt(from = 0, until = players.size))
            while (true) {
                randomVersusPlayer =
                    players.get(index = Random.nextInt(from = 0, until = players.size))

                if (randomPlayer != randomVersusPlayer) {
                    versusTaskGenerationStrategy.generateTask(null, randomPlayer, randomVersusPlayer, tasks)
                    break
                }
            }

            for (i in players.indices) {
                individualTaskGenerationStrategy.generateTask(null, players[i], null, tasks)
            }
        }
        return tasks
    }
}