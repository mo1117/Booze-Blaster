package com.boozeblaster.generators.taskFactories

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.versus.VersusTask
import com.boozeblaster.utils.GameSettings

object VersusTaskFactory : TaskFactory {

    override val createTask: (player: Player?, versusPlayer: Player?, generateSipTransferTask: Boolean?) -> Task =
        { player: Player?, versusPlayer: Player?, _: Boolean? ->
            val randomVersusTask = GameSettings.getVersusTasks().random()
            VersusTask::class.sealedSubclasses.find { versusTask ->
                versusTask.simpleName!!.contains(other = randomVersusTask)
            }!!.constructors.first().call(player, versusPlayer)
        }
}