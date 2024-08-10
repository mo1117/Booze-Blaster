package com.boozeblaster.generators.strategy

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.VersusTask
import com.boozeblaster.utils.GameSettings

class VersusTaskGenerationStrategy : TaskGenerationStrategy {

    override val generateTask: (Boolean?, Player?, Player?, List<Task>) -> List<Task> = {
        _, player, versusPlayer, tasks ->
        if (!GameSettings.playVersusTasks()) {
            tasks
        }
        tasks.plus(generateVersusTask(player!!, versusPlayer!!))
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