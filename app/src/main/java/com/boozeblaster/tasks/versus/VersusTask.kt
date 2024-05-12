package com.boozeblaster.tasks.versus

import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task

sealed class VersusTask(player: Player, subTasks: List<MiniGame>, versusPlayer: Player) :
    Task(player = player, subTasks = subTasks, versusPlayer = versusPlayer)