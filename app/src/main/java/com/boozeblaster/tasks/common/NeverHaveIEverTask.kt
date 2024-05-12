package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.generators.common.NeverHaveIEverGenerator
import com.boozeblaster.minigames.MiniGame

class NeverHaveIEverTask(
    subTasks: List<MiniGame> = NeverHaveIEverGenerator().getList()
) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Never Have I Ever"

    override fun getImageId(): Int = R.drawable.guessing

    override fun getCoverDescription(): String = "There will be three tasks of Never Have I " +
            "Ever coming up.\n\nPlayers that have done said statement have to drink, " +
            "others will be rewarded points."
}