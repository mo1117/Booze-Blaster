package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.generators.versus.MentalArithmeticGenerator
import com.boozeblaster.models.Player

class MentalArithmeticTask(
    player: Player,
    versusPlayer: Player
) : VersusTask(
    player = player,
    subTasks = MentalArithmeticGenerator().getList(),
    versusPlayer = versusPlayer
) {

    override fun getName(): String = "Mental Arithmetic"

    override fun getImageId(): Int = R.drawable.calculating

    override fun getCoverDescription(): String = "Provide the correct solution to the " +
            "given expression!\n\nWhoever answers first, wins!\n\nIf someone answers incorrectly," +
            " the other player wins!"
}