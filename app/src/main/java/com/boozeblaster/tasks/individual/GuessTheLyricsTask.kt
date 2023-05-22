package com.boozeblaster.tasks.individual

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class GuessTheLyricsTask (
    private val player: Player,
    private val subTasks: List<GuessTheLyrics>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {
    @Composable
    override fun DisplayContent() {
        Text(text = "Guess the lyrics")
    }
}