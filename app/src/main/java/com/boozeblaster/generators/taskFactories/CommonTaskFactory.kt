package com.boozeblaster.generators.taskFactories

import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.common.CommonTask
import com.boozeblaster.tasks.common.SipTransferTask
import com.boozeblaster.utils.GameSettings
import kotlin.reflect.full.createInstance

object CommonTaskFactory : TaskFactory {

    override val createTask: (player: Player?, versusPlayer: Player?, generateSipTransferTask: Boolean?) -> Task =
        { _: Player?, _: Player?, generateSipTransferTask: Boolean? ->
            if (generateSipTransferTask!!) {
                SipTransferTask(subTasks = listOf(SipTransfer()))
            } else {
                val randomCommonTask = GameSettings.getCommonTasks().random()
                CommonTask::class.sealedSubclasses.find { commonTask ->
                    commonTask.simpleName!!.contains(other = randomCommonTask)
                }!!.createInstance()
            }
        }
}