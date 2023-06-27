package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheTheme

class GuessTheThemeGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    private companion object {
        private val list = listOf(
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
            GuessTheTheme(movieName = "", resid = 1),
        )
    }
}