package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class GuessTheLyricsTask(
    player: Player,
    subTasks: List<GuessTheLyrics>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {

    override fun getName(): String = "Guess The Lyrics"

    override fun getImageId(): Int = R.drawable.lyrics

    override fun getCoverDescription(): String = "You will have to guess the following three " +
            "lyrics completions.\n\n If you guess it correctly, you will be rewarded " +
            "with points.\n\n When not knowing any of the upcoming lyrics, you drink!\n\n" +
            "When having the lyrics partially correct, points and sips will be halved!"
}