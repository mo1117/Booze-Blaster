package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.generators.common.WhoInThisRoomGenerator
import com.boozeblaster.minigames.MiniGame

class WhoInThisRoomTask(
    subTasks: List<MiniGame> = WhoInThisRoomGenerator().getList()
) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Who In This Room"

    override fun getImageId(): Int = R.drawable.guessing

    override fun getCoverDescription(): String = "Do your own countdown and point to the player " +
            "that you thought of first when you heard the statement!\n\nThe loser(s) drink(s)!"
}