package com.boozeblaster.tasks

import com.boozeblaster.minigames.MiniGame

abstract class CommonTask(subTasks: List<MiniGame>) :
    Task(player = null, subTasks = subTasks)