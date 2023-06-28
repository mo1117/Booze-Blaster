package com.boozeblaster.minigames

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

abstract class MiniGame {

    protected val fontSize = 20
    protected val fontFamily = FontFamily.SansSerif

    protected var points = 0
    protected var sips = 0
    protected var showDialog = false

    /**
     * Every type of MiniGame needs to implement the DisplayContent method
     *
     * The callback function is used to show the content of the following subTask, which is a
     * MiniGame
     */
    @Composable
    abstract fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?)

    fun addPoints(player: Player, points: Int) {
        player.addPoints(points = points)
    }

    fun addPoints(players: List<Player>, points: Int) {
        players.forEach(action = { player -> player.addPoints(points = points) })
    }

    fun addSips(player: Player, sips: Int) {
        player.addSips(sips = sips)
    }

    fun addSips(players: List<Player>, sips: Int) {
        players.forEach(action = { player -> player.addSips(sips = sips) })
    }

    fun addPointsOrSips(playersToGetSips: List<Player>, points: Int, sips: Int) {
        for (player in Game.getPlayers()) {
            if (playersToGetSips.contains(element = player)) {
                player.addSips(sips = sips)
            } else {
                player.addPoints(points = points)
            }
        }
    }
}