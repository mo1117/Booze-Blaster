package com.boozeblaster.generators.versus

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.versus.RockPaperScissors

class RockPaperScissorsGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        //Only display one screen here
        return listOf(RockPaperScissors())
    }
}