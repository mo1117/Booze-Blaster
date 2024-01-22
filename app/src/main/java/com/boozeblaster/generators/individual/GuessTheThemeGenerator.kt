package com.boozeblaster.generators.individual

import com.boozeblaster.R
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheTheme

class GuessTheThemeGenerator : MiniGameGenerator() {

    @Override
    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3, resetAllToUnused = false)
    }

    private companion object {
        private val list = listOf(
            GuessTheTheme(
                name = "Malcom in the Middle",
                resid = R.raw.malcom_in_the_middle,
                duration = 11500
            ),
            GuessTheTheme(
                name = "The Simpsons",
                resid = R.raw.the_simpsons_series,
                duration = 12000
            ),
            GuessTheTheme(name = "Avatar", resid = R.raw.avatar),
            GuessTheTheme(name = "Family Guy", resid = R.raw.family_guy),
            GuessTheTheme(name = "Friends", resid = R.raw.friends),
            GuessTheTheme(name = "Ghostbusters", resid = R.raw.ghostbusters),
            GuessTheTheme(name = "Game of Thrones", resid = R.raw.got),
            GuessTheTheme(name = "Interstellar", resid = R.raw.interstellar),
            GuessTheTheme(name = "James Bond", resid = R.raw.james_bond),
            GuessTheTheme(name = "Jaws", resid = R.raw.jaws),
            GuessTheTheme(name = "Jimmy Neutron", resid = R.raw.jimmy_neutron),
            GuessTheTheme(name = "The Lion King", resid = R.raw.lion_king),
            GuessTheTheme(name = "The Lord of the Rings", resid = R.raw.lotr),
            GuessTheTheme(name = "Pink Panther", resid = R.raw.pink_panther),
            GuessTheTheme(name = "Pirates of the Caribbean", resid = R.raw.pirates_of_the_caribbean),
            GuessTheTheme(name = "Rocky", resid = R.raw.rocky),
            GuessTheTheme(name = "Skyrim", resid = R.raw.skyrim),
            GuessTheTheme(name = "Star Wars", resid = R.raw.star_wars),
            GuessTheTheme(name = "Tetris", resid = R.raw.tetris)
            )
    }
}