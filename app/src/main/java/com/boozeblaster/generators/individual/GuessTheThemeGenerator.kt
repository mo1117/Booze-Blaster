package com.boozeblaster.generators.individual

import com.boozeblaster.R
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheTheme

class GuessTheThemeGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    private companion object {
        private val list = listOf(
            GuessTheTheme(
                name = "Malcom in the Middle",
                resid = R.raw.malcom_in_the_middle,
                duration = 11500
            ),
            GuessTheTheme(
                name = "The Simpsons - Series",
                resid = R.raw.the_simpsons_series,
                duration = 12000
            ),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),
            GuessTheTheme(name = "", resid = 1),

            )
    }
}