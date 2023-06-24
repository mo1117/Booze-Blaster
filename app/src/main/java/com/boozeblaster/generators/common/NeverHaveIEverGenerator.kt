package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.models.Game

class NeverHaveIEverGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        val list = if (Game.isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = 3)
    }

    /**
     * Two lists consisting of NeverHaveIEver instances
     *
     * One list for the normal mode, and one for adult mode
     */
    private companion object {
        private val normalList = listOf(
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
        )
        private val adultModeList = listOf(
            NeverHaveIEver(statement = "Done Cocaine in Munich."),
            NeverHaveIEver(statement = "Done Cocaine in Munich."),
            NeverHaveIEver(statement = "Done Cocaine in Munich."),
//            NeverHaveIEver(statement = ""),
        )
    }
}