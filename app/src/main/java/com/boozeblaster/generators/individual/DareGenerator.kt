package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Game

class DareGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        val list = if (Game.getInstance().isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = Game.getInstance().getPlayers().size)
    }

    /**
     * Normal list and adult mode list - make it inconvenient ;)
     */
    private companion object {
        private val normalList = listOf(
            Dare(dare = "Hug everyone in this room!"),
            Dare(dare = "Hug everyone in this room!"),
            Dare(dare = "Hug everyone in this room!"),
            Dare(dare = "Hug everyone in this room!")
        )
        private val adultModeList = listOf(
            Dare(dare = "Kiss everyone in this room!")
        )
    }
}