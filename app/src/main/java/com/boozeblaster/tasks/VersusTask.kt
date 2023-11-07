package com.boozeblaster.tasks

import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

abstract class VersusTask(player: Player, subTasks: List<MiniGame>, versusPlayer: Player) :
    Task(player = player, subTasks = subTasks, versusPlayer = versusPlayer)