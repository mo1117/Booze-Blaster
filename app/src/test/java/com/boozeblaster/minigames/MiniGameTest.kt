package com.boozeblaster.minigames

import androidx.compose.runtime.Composable
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.reflect.Modifier

class MiniGameTest {

    private val player = Player(name = "John")
    private val players = listOf(Player(name = "Johnny"), Player(name = "Herbert"))
    private val simpleMiniGame = SimpleMiniGame()

    @Test
    fun testMiniGameShouldBeAbstract() {
        assertTrue(Modifier.isAbstract(Class.forName("com.boozeblaster.minigames.MiniGame").modifiers))
    }

    @Test
    fun testAddPointsForSinglePlayer() {
        simpleMiniGame.addPoints(player = player, points = 10)
        assertEquals(10, player.getPoints())
    }

    @Test
    fun testAddPointsForMultiplePlayers() {
        simpleMiniGame.addPoints(players = players, points = 5)
        assertEquals(5, players.get(index = 0).getPoints())
        assertEquals(5, players.get(index = 1).getPoints())
    }

    @Test
    fun testAddPointsForSingleAndMultiplePlayers() {
        simpleMiniGame.addPoints(players = players, points = 5)
        simpleMiniGame.addPoints(player = players.get(index = 0), points = 5)
        assertEquals(10, players.get(index = 0).getPoints())
        assertEquals(5, players.get(index = 1).getPoints())
    }

    @Test
    fun testAddSipsForSinglePlayer() {
        simpleMiniGame.addSips(player = player, sips = 5)
        assertEquals(5, player.getSips())
    }

    @Test
    fun testAddSipsForMultiplePlayers() {
        simpleMiniGame.addSips(players = players, sips = 5)
        assertEquals(5, players.get(index = 0).getSips())
        assertEquals(5, players.get(index = 1).getSips())
    }

    @Test
    fun testAddSipsForSingleAndMultiplePlayers() {
        simpleMiniGame.addSips(player = players.get(index = 0), sips = 5)
        simpleMiniGame.addSips(players = players, sips = 5)
        assertEquals(10, players.get(index = 0).getSips())
        assertEquals(5, players.get(index = 1).getSips())
    }

    @Test
    fun testAddPointsAndSips() {
        simpleMiniGame.addPointsAndSips(player = player, points = 5, sips = 7)
        assertEquals(5, player.getPoints())
        assertEquals(7, player.getSips())
    }

    @Test
    fun testAddPointsOrSips() {
        val players = players.plus(element = Player(name = "Susi"))
        Game.setPlayers(players = players)
        simpleMiniGame.addPointsOrSips(playersToGetSips = this.players, points = 5, sips = 7)
        assertEquals(5, players.stream().mapToInt(Player::getPoints).sum())
        assertEquals(14, players.stream().mapToInt(Player::getSips).sum())
    }

    @Test
    fun testMiniGameShouldNotBeUsedByDefault() {
        assertFalse(simpleMiniGame.hasBeenUsed())
    }

    class SimpleMiniGame : MiniGame() {
        @Composable
        override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {
            // STUB
        }
    }

}