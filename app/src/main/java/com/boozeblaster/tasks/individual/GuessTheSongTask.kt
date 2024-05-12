package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.generators.individual.GuessTheSongGenerator
import com.boozeblaster.models.Player

class GuessTheSongTask(
    player: Player
) : IndividualTask(
    player = player,
    subTasks = GuessTheSongGenerator().getList()
) {

    override fun getName(): String = "Guess The Song"

    override fun getImageId(): Int = R.drawable.guessing

    override fun getCoverDescription(): String = "You will have to guess the following three " +
            "songs.\n\nIf you cannot name both artist and the song's name, you will drink the " +
            "full amount!\n\n If you are able to guess both correct, you will be rewarded full " +
            "points instead!\n\nIf only one guess is correct, points and sips will both be " +
            "halved."
}