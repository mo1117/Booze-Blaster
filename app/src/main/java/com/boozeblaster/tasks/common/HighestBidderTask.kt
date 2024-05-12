package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.generators.common.HighestBidderGenerator
import com.boozeblaster.minigames.MiniGame

class HighestBidderTask(subTasks: List<MiniGame> = HighestBidderGenerator().getList()) :
    CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Highest Bidder"

    override fun getImageId(): Int = R.drawable.higher_lower

    override fun getCoverDescription(): String = "You can now gather points by offering the most " +
            "sips.\n\nWhoever bids the most sips, will be rewarded with a certain amount of " +
            "points!\n\nImportant: If someone bids an amount, it cannot be undone!\n\nAlways " +
            "increment the bid by clicking on the button."
}