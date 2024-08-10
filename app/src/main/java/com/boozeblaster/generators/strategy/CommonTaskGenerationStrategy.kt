package com.boozeblaster.generators.strategy

import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.common.SipTransferTask
import com.boozeblaster.utils.GameSettings

class CommonTaskGenerationStrategy : TaskGenerationStrategy {

    override val generateTask: (Boolean?, List<Player>?, List<Task>) -> List<Task> = {
        sipTransfer, _, tasks ->
        if (!GameSettings.playCommonTasks()) {
            tasks
        }
        tasks.plus(generateCommonTask(sipTransfer!!))
    }

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
}