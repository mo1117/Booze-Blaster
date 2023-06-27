package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.tasks.CommonTask

class NeverHaveIEverTask(
    private val subTasks: List<NeverHaveIEver>
) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Never Have I Ever"

    override fun getImageId(): Int = R.drawable.delete //TODO

    override fun getCoverDescription(): String = "There will be three tasks of Never Have I " +
            "Ever coming up.\n\nPlayers that have done said statement have to drink, " +
            "others will be rewarded points."
}