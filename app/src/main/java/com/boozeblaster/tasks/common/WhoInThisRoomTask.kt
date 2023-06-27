package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.minigames.common.WhoInThisRoom
import com.boozeblaster.tasks.CommonTask

class WhoInThisRoomTask(
    private val subTasks: List<WhoInThisRoom>
) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Who In This Room"

    override fun getImageId(): Int = R.drawable.guessing

    override fun getCoverDescription(): String = "Do your own countdown and point to the player " +
            "that you thought of first when you heard the statement!\n\nThe loser(s) drink(s)!"
}