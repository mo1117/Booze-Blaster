package com.boozeblaster.generators.strategy

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.tasks.Task
import com.boozeblaster.utils.GameSettings

class IndividualTaskGenerationStrategy : TaskGenerationStrategy {

    override val generateTask: (Boolean?, List<Player>?, List<Task>) -> List<Task> = {
        _, players, tasks ->
        var newTasks = tasks
        if (!GameSettings.playIndividualTasks()) {
            tasks
        }
        for (i in players!!.indices) {
            newTasks = tasks.plus(generateIndividualTask(players[i]))
        }
        newTasks
    }

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
}