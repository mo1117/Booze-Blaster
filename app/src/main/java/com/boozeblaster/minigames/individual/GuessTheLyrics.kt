package com.boozeblaster.minigames.individual

import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class GuessTheLyrics(
    private val songName: String,
    private val artist: String,
    private val lyrics: String,
    private val lyricsCompletion: String,
): MiniGame() {
    override fun play(player: Player) {
        TODO("Not yet implemented")
    }
}