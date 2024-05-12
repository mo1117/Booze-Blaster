package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.generators.versus.RockPaperScissorsGenerator
import com.boozeblaster.models.Player

class RockPaperScissorsTask(
    player: Player,
    versusPlayer: Player
) : VersusTask(
    player = player,
    subTasks = RockPaperScissorsGenerator().getList(),
    versusPlayer = versusPlayer
) {

    override fun getName(): String = "Rock-Paper-Scissors"

    override fun getImageId(): Int = R.drawable.rock_paper_scissors

    override fun getCoverDescription(): String = "A simple Best of 5 will decide your faiths!\n\n" +
            "The winner will be rewarded 2 points, the loser must drink!"
}