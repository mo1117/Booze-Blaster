package com.boozeblaster.generators

import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.VersusTask
import com.boozeblaster.tasks.common.SipTransferTask
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
                        element = generateCommonTask(
                            generateSipTransferTask = rounds - round == 1 && rounds > 1
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
                            element = generateVersusTask(
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
                        tasks.plus(element = generateIndividualTask(player = players.get(index = i)))
                }
            }
        }
        return tasks
    }

    /**
     * Generates a random common task
     * @param generateSipTransferTask Whether we want to generate a sip transfer task
     * @return CommonTask (Specific common task - Or a SipTransferTask if we are in the last round)
     * @see TaskGenerator.generateIndividualTask
     * @see CommonTask
     */
    private fun generateCommonTask(generateSipTransferTask: Boolean): CommonTask {
        if (generateSipTransferTask) {
            return SipTransferTask(subTasks = listOf(SipTransfer()))
        }
        val game = getRandomTask(availableTasks = GameSettings.getCommonTasks())

        val constructor = Class.forName("com.boozeblaster.tasks.common.${game}Task")
            .getConstructor(List::class.java)

        val instance = Class.forName("com.boozeblaster.generators.common.${game}Generator")
            .newInstance()

        val generator = Class.forName("com.boozeblaster.generators.common.${game}Generator")
            .getMethod("getList")

        return constructor.newInstance(generator.invoke(instance)) as CommonTask
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
     * @return IndividualTask
     * @see IndividualTask
     */
    private fun generateIndividualTask(player: Player): IndividualTask {
        val game = getRandomTask(availableTasks = GameSettings.getIndividualTasks())

        val constructor = Class.forName("com.boozeblaster.tasks.individual.${game}Task")
            .getConstructor(Player::class.java, List::class.java)

        val instance = Class.forName("com.boozeblaster.generators.individual.${game}Generator")
            .newInstance()

        val generator = Class.forName("com.boozeblaster.generators.individual.${game}Generator")
            .getMethod("getList")

        return constructor.newInstance(player, generator.invoke(instance)) as IndividualTask
    }

    /**
     * Generates a random VersusTask
     * @see VersusTask
     */
    private fun generateVersusTask(player: Player, versusPlayer: Player): VersusTask {
        val game = getRandomTask(availableTasks = GameSettings.getVersusTasks())

        val constructor = Class.forName("com.boozeblaster.tasks.versus.${game}Task")
            .getConstructor(Player::class.java, List::class.java, Player::class.java)

        val instance = Class.forName("com.boozeblaster.generators.versus.${game}Generator")
            .newInstance()

        val generator = Class.forName("com.boozeblaster.generators.versus.${game}Generator")
            .getMethod("getList")

        return constructor.newInstance(
            player,
            generator.invoke(instance),
            versusPlayer
        ) as VersusTask
    }

    private fun getRandomTask(availableTasks: Array<String>): String {
        return availableTasks[Random.nextInt(from = 0, until = availableTasks.size)]
    }
}