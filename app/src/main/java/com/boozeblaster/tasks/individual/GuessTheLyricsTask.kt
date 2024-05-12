package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.generators.individual.GuessTheLyricsGenerator
import com.boozeblaster.models.Player

class GuessTheLyricsTask(
    player: Player
) : IndividualTask(
    player = player,
    subTasks = GuessTheLyricsGenerator().getList()
) {

    override fun getName(): String = "Guess The Lyrics"

    override fun getImageId(): Int = R.drawable.lyrics

    override fun getCoverDescription(): String = "You will have to guess the following three " +
            "lyrics completions.\n\n If you guess it correctly, you will be rewarded " +
            "with points.\n\n When not knowing any of the upcoming lyrics, you drink!\n\n" +
            "When having the lyrics partially correct, points and sips will be halved!"
}