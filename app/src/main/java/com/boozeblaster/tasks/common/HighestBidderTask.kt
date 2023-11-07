package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.minigames.common.HighestBidder
import com.boozeblaster.tasks.CommonTask

class HighestBidderTask(subTasks: List<HighestBidder>) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Highest Bidder"

    override fun getImageId(): Int = R.drawable.delete //TODO

    override fun getCoverDescription(): String = "You can now gather points by offering the most " +
            "sips.\n\nWhoever bids the most sips, will be rewarded with a certain amount of " +
            "points!\n\nImportant: If someone bids an amount, it cannot be undone!\n\nAlways " +
            "increment the bid by clicking on the button."
}