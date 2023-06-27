package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

abstract class VersusTask(player: Player, subTasks: List<MiniGame>, versusPlayer: Player) :
    Task(player = player, subTasks = subTasks, versusPlayer = versusPlayer) {

    @Composable
    override fun Display(callback: () -> Unit) {
        TODO("Not yet implemented")
    }
}