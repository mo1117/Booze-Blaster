package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.VersusTask

class RockPaperScissorsTask(player: Player, versusPlayer: Player) :
    VersusTask(player = player, subTasks = emptyList(), versusPlayer = versusPlayer) {

    override fun getName(): String = "Rock-Paper-Scissors"

    override fun getImageId(): Int = R.drawable.delete //TODO

    override fun getCoverDescription(): String = "A simple Best of 5 will decide your faiths!\n\n" +
            "The winner will be rewarded 2 points, the loser must drink!"
}