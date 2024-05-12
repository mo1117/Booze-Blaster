package com.boozeblaster.generators.taskFactories

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.individual.IndividualTask
import com.boozeblaster.utils.GameSettings

object IndividualTaskFactory : TaskFactory {

    override val createTask: (player: Player?, versusPlayer: Player?, generateSipTransferTask: Boolean?) -> Task =
        { player: Player?, _: Player?, _: Boolean? ->
            val randomIndividualTask = GameSettings.getIndividualTasks().random()
            IndividualTask::class.sealedSubclasses.find { individualTask ->
                individualTask.simpleName!!.contains(other = randomIndividualTask)
            }!!.constructors.first().call(player)
        }
}