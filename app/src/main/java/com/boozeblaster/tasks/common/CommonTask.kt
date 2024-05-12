package com.boozeblaster.tasks.common

import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.tasks.Task

sealed class CommonTask(subTasks: List<MiniGame>) :
    Task(player = null, subTasks = subTasks)