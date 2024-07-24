package com.boozeblaster.generators

import com.boozeblaster.generators.taskFactories.CommonTaskFactory
import com.boozeblaster.generators.taskFactories.IndividualTaskFactory
import com.boozeblaster.generators.taskFactories.TaskFactory
import com.boozeblaster.generators.taskFactories.VersusTaskFactory
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.utils.GameSettings
import kotlin.random.Random

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
            if (GameSettings.playCommonTasks()) {
                tasks =
                    tasks.plus(
                        element = generateTask(
                            taskFactory = CommonTaskFactory,
                            generateSipTransferTask = rounds - round == 1 && rounds > 1 && GameSettings.playSipTransfer()
                        )
                    )
            }

            if (GameSettings.playVersusTasks()) {
                randomPlayer = players.get(index = Random.nextInt(from = 0, until = players.size))
                while (true) {
                    randomVersusPlayer =
                        players.get(index = Random.nextInt(from = 0, until = players.size))

                    if (randomPlayer != randomVersusPlayer) {
                        tasks = tasks.plus(
                            element = generateTask(
                                taskFactory = VersusTaskFactory,
                                player = randomPlayer,
                                versusPlayer = randomVersusPlayer
                            )
                        )
                        break
                    }
                }
            }

            if (GameSettings.playIndividualTasks()) {
                for (i in players.indices) {
                    tasks =
                        tasks.plus(
                            element = generateTask(
                                taskFactory = IndividualTaskFactory,
                                player = players.get(index = i)
                            )
                        )
                }
            }
        }
        return tasks
    }

    private fun generateTask(
        taskFactory: TaskFactory,
        player: Player? = null,
        versusPlayer: Player? = null,
        generateSipTransferTask: Boolean? = null
    ): Task = taskFactory.createTask(player, versusPlayer, generateSipTransferTask)
}