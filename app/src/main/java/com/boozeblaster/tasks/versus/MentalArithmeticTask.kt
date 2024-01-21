package com.boozeblaster.tasks.versus

import com.boozeblaster.minigames.versus.MentalArithmetic
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.VersusTask
import com.boozeblaster.R

class MentalArithmeticTask(
    player: Player,
    subTasks: List<MentalArithmetic>,
    versusPlayer: Player
) : VersusTask(player = player, subTasks = subTasks, versusPlayer = versusPlayer) {

    override fun getName(): String = "Mental Arithmetic"

    override fun getImageId(): Int = R.drawable.calculating

    override fun getCoverDescription(): String = "Provide the correct solution to the " +
            "given expression!\n\nWhoever answers first, wins!\n\nIf someone answers incorrectly," +
            " the other player wins!"
}