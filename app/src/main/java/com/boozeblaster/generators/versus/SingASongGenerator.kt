package com.boozeblaster.generators.versus

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.versus.SingASong
import com.boozeblaster.models.Game

class SingASongGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        val list = if (Game.isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = 5, resetAllToUnused = false)
    }

    private companion object {
        private val normalList = listOf(
            SingASong(statement = "Sing a song that starts with A."),
            SingASong(statement = "Sing a song from Lady Gaga."),
            SingASong(statement = "Sing a song from Rihanna."),
            SingASong(statement = "Sing a song from Justin Bieber."),
            SingASong(statement = "Sing a song from the 80's."),
            SingASong(statement = "Sing a song from the 90's."),
            SingASong(statement = "Sing a song from Linkin Park."),
            SingASong(statement = "Sing a song from The Beatles."),
            SingASong(statement = "Sing a song from someone who already passed away."),
            SingASong(statement = "Sing a song from someone that is old.", crowdDecides = true),
            SingASong(statement = "Sing a German Song."),
            SingASong(statement = "Sing a Spanish song."),
            SingASong(statement = "Sing a French Song."),
            SingASong(statement = "Sing an Austrian Song."),
            SingASong(statement = "Sing a song that starts with Z."),
            SingASong(statement = "Sing a song from Lil Peep."),
            SingASong(statement = "Sing a song from Juice WRLD."),
            SingASong(statement = "Sing a sad song.", crowdDecides = true),
            SingASong(
                statement = "Sing a song that only you have ever heard before!",
                crowdDecides = true
            ),
            SingASong(statement = "Sing a song from the 2000's."),
            SingASong(statement = "Sing a song that is not older than 6 months."),
            SingASong(statement = "Sing a song from Post Malone."),
            SingASong(
                statement = "Sing a song that everyone in this room knows!",
                crowdDecides = true
            ),
            SingASong(statement = "Sing a song from Bob Marley."),
            SingASong(statement = "Sing a song from Lil Durk."),
            SingASong(statement = "Sing a song from Coldplay."),
            SingASong(statement = "Sing a song from Bruno Mars."),
            SingASong(
                statement = "Sing a song that is about a 'special girl'.",
                crowdDecides = true
            ),
            SingASong(statement = "Sing a song that is about love.", crowdDecides = true),
            SingASong(statement = "Sing a song that has the word 'dreams' in it."),
            SingASong(statement = "Sing a song that has the word 'marry' in it."),
            SingASong(
                statement = "Sing a song that was used as a theme song for any Spider" +
                        "-Man movie."
            ),
            SingASong(statement = "Sing a song with a one-word title."),
            SingASong(
                statement = "Sing a song that mentions a specific city or country.",
                crowdDecides = true
            ),
            SingASong(statement = "Sing a song that is about friendship.", crowdDecides = true),
            SingASong(statement = "Sing a song with a number in the title."),
            SingASong(
                statement = "Sing a song with a sing or dance movie associated to it.",
                crowdDecides = true
            ),
            SingASong(statement = "Sing a song that includes a guitar solo.", crowdDecides = true),
            SingASong(statement = "Sing a song from the Red Hot Chili Peppers."),
            SingASong(statement = "Sing a song from Oliver Tree."),
            SingASong(statement = "Sing a song from Machine Gun Kelly."),
            SingASong(statement = "Sing a song from a famous kid's TV-Show.", crowdDecides = true),
            SingASong(statement = "Sing a song"),
        )
        private val adultModeList = normalList.plus(
            elements = listOf(
                SingASong(statement = "Sing a Song that is about sex."),
                SingASong(statement = "Sing a Song that is about drugs."),
                SingASong(statement = "Sing a Song from an artist that died from a drug overdose."),
                SingASong(statement = "Sing a Song that contains the N-Word."),
                SingASong(statement = "Sing a Song from a gay or lesbian artist."),
                SingASong(
                    statement = "Sing a Song that is insulting towards society.",
                    crowdDecides = true
                ),
                SingASong(statement = "Sing a Song that is offensive.", crowdDecides = true),
                SingASong(statement = "Sing a Song that is about suicide.", crowdDecides = true),
                SingASong(statement = "Sing a Song that is about murder.", crowdDecides = true),
                SingASong(statement = "Sing a Song that is about weed.", crowdDecides = true),
                SingASong(
                    statement = "Sing a Song from an artist that is a known stoner.",
                    crowdDecides = true
                ),
                SingASong(statement = "Sing a Song that has the word 'kill' in it."),
                SingASong(
                    statement = "Sing a Song that was used as a theme-song for any " +
                            "Fifty Shades of Grey movie."
                ),
                SingASong(statement = "Sing a Song from an artist that has killed someone in " +
                        "real life."),
                SingASong(statement = "Sing a Song from an artist that has done or is doing " +
                        "drugs.", crowdDecides = true),
                SingASong(statement = "Sing a Song"),
            )
        )
    }
}