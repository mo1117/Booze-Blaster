package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.common.HighestBidder

class HighestBidderGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 1)
    }

    private companion object {
        private val list = listOf(
            HighestBidder(pointsToGet = 5),
            HighestBidder(pointsToGet = 6),
            HighestBidder(pointsToGet = 7),
            HighestBidder(pointsToGet = 8),
            HighestBidder(pointsToGet = 9),
            HighestBidder(pointsToGet = 10),
            HighestBidder(pointsToGet = 11),
            HighestBidder(pointsToGet = 12),
            HighestBidder(pointsToGet = 13),
            HighestBidder(pointsToGet = 14),
            HighestBidder(pointsToGet = 15),
            HighestBidder(pointsToGet = 16),
            HighestBidder(pointsToGet = 17),
            HighestBidder(pointsToGet = 18),
            HighestBidder(pointsToGet = 19),
            HighestBidder(pointsToGet = 20)
        )
    }
}