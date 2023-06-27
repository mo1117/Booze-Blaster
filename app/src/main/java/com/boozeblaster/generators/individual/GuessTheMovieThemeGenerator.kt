package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheMovieTheme

class GuessTheMovieThemeGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    private companion object {
        private val list = listOf(
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
            GuessTheMovieTheme(movieName = "", resid = 1),
        )
    }
}