package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Game

class DareGenerator : MiniGameGenerator() {

    /**
     * Here we return the complete list of dares, matching the dares to the players is done in our
     * DareTaskGenerator
     * @see com.boozeblaster.generators.DareTaskGenerator
     */
    override fun getList(): List<MiniGame> {
        return if (Game.isAdultMode()) adultModeList else normalList
    }

    /**
     * Normal list and adult mode list - make it inconvenient ;)
     */
    private companion object {
        private val normalList = listOf(
            Dare(dare = "Hug everyone in this room!1"),
            Dare(dare = "Hug everyone in this room!2"),
            Dare(dare = "Hug everyone in this room!3"),
            Dare(dare = "Hug everyone in this room!4"),
            Dare(dare = "Hug everyone in this room!5"),
            Dare(dare = "Hug everyone in this room!6"),
            Dare(dare = "Hug everyone in this room!7"),
            Dare(dare = "Hug everyone in this room!8"),
            Dare(dare = "Hug everyone in this room!9"),
        )
        private val adultModeList = listOf(
            Dare(dare = "Kiss everyone in this room!")
        )
    }
}