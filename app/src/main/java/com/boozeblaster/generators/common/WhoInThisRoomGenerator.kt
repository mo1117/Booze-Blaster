package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.common.WhoInThisRoom
import com.boozeblaster.models.Game

class WhoInThisRoomGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        val list = if (Game.getInstance().isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = 4)
    }

    /**
     * Each question starts with "Who in this room..."
     *
     * One list for the normal mode, and one list for adult mode
     */
    private companion object {
        private val normalList = listOf(
            WhoInThisRoom(statement = "Is most likely to drive drunk?"),
            WhoInThisRoom(statement = "Is the biggest alcoholic?"),
            WhoInThisRoom(statement = "Speaks English most fluently?"),
            WhoInThisRoom(statement = "Speaks the most languages?"),
            WhoInThisRoom(statement = "Is the best car driver?"),
            WhoInThisRoom(statement = "Is the worst car driver?"),
            WhoInThisRoom(statement = "Is most likely to become a parent first?"),
            WhoInThisRoom(statement = "Looks the best?"),
            WhoInThisRoom(statement = "Smells the best?"),
            WhoInThisRoom(statement = "Smells the worst?"),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
        )
        private val adultModeList = listOf(
            WhoInThisRoom(statement = "Most likely to..."),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
            WhoInThisRoom(statement = ""),
        )
    }
}