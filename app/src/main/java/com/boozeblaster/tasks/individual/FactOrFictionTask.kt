package com.boozeblaster.tasks.individual

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.individual.FactOrFiction
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

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
    player: Player,
    subTasks: List<FactOrFiction>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {

    @Composable
    override fun displayContent() {
        //TODO load the compose content for the screen (GameScreen)
    }

}