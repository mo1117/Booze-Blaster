package com.boozeblaster.generators.strategy

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.VersusTask
import com.boozeblaster.utils.GameSettings
import kotlin.random.Random

class VersusTaskGenerationStrategy : TaskGenerationStrategy {

    override val generateTask: (Boolean?, List<Player>?, List<Task>) -> List<Task> = {
        _, players, tasks ->
        if (!GameSettings.playVersusTasks()) {
            tasks
        }
        val randomPlayer = players!!.get(index = Random.nextInt(from = 0, until = players.size))
        var randomVersusPlayer: Player
        while (true) {
            randomVersusPlayer = players.get(index = Random.nextInt(from = 0, until = players.size))

            if (randomPlayer != randomVersusPlayer) {
                tasks.plus(generateVersusTask(randomPlayer, randomVersusPlayer))
                break
            }
        }
        tasks
    }

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
}