package com.boozeblaster.generators.taskFactories

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task

interface TaskFactory {

    val createTask: (player: Player?, versusPlayer: Player?, generateSipTransferTask: Boolean?) -> Task

}