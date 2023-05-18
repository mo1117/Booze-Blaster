package com.boozeblaster.tasks.individual

import androidx.compose.runtime.Composable
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
    @Composable
    override fun displayContent() {
        //TODO Here we load the compose content for the screen
    }
}