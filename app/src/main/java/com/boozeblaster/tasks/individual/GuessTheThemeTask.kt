package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.generators.individual.GuessTheThemeGenerator
import com.boozeblaster.models.Player

class GuessTheThemeTask(
    player: Player
) :
    IndividualTask(player = player, subTasks = GuessTheThemeGenerator().getList()) {

    override fun getName(): String = "Guess The Theme"

    override fun getImageId(): Int = R.drawable.guessing

    override fun getCoverDescription(): String = "You will have to guess the following three " +
            "movies, TV-series, or video games based on a music that is to be played.\n\nNote " +
            "that this does not have to be their theme song, it might just be a melody that is " +
            "linked to it.\n\n If you guess it correctly, you will be rewarded with points.\n\n" +
            "In case you are not totally sure, still take a guess - close answers might still get " +
            "you a point!\n\nIf you are wrong, you drink!"
}