package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.minigames.individual.GuessTheTheme
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class GuessTheThemeTask(
    player: Player,
    subTasks: List<GuessTheTheme>
) :
    IndividualTask(player = player, subTasks = subTasks) {

    override fun getName(): String = "Guess The Theme"

    override fun getImageId(): Int = R.drawable.guessing //TODO maybe another image

    override fun getCoverDescription(): String = "You will have to guess the following three " +
            "movies, TV-series, or video games, based on their theme songs.\n\n If you guess it " +
            "correctly, you will be rewarded with points.\n\nIn case you are not totally sure, " +
            "still take a guess - close answers might still get you a point!\n\nIf you are " +
            "wrong, you drink!"
}