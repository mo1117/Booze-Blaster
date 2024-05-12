package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.generators.individual.FactOrFictionGenerator
import com.boozeblaster.models.Player

/**
 * A class that represents the Fact or Fiction mini-game
 *
 * Each assigned player will get three different statements displayed
 *
 * Every statement has to be labeled as fact or fiction
 *
 * 1 point per correct answer can be achieved
 */
class FactOrFictionTask(
    player: Player
) : IndividualTask(
    player = player,
    subTasks = FactOrFictionGenerator().getList()
) {
    override fun getName(): String = "Fact Or Fiction"

    override fun getImageId(): Int = R.drawable.fact_or_fiction

    override fun getCoverDescription(): String = "Guess if the following statements are true " +
            "or false!\n\nIf you are correct, you are rewarded a point.\n\nOtherwise you drink!"
}