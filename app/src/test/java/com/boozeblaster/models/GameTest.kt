package com.boozeblaster.models

import com.boozeblaster.minigames.individual.Dare
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test
import kotlin.random.Random

class GameTest {

    @Test
    fun testGameContainsNoPublicConstructor() {
        try {
            Game::class.java.getConstructor()
            fail(
                "There should be no public constructor available in the Game class! " +
                        "Keep it a singleton object."
            )
        } catch (e: NoSuchMethodException) {
            assertTrue(true)
        }
    }

    @Test
    fun testSetPlayers() {
        setPlayers()
        assertEquals(4, Game.getPlayers().size)
    }

    @Test
    fun testZeroPointsAtStart() {
        setPlayers()
        Game.getPlayers().get(index = 1).setPoints(points = 10)
        Game.load()
        assertTrue(Game.getPlayers().stream().allMatch { player -> player.getPoints() == 0 })
    }

    @Test
    fun testResetPlayers() {
        setPlayers()
        Game.reset()
        assertEquals(0, Game.getPlayers().size)
    }

    @Test
    fun testResetAllDares() {
        setPlayers()
        setDare(player = Game.getPlayers().get(index = 1))
        Game.resetAllDares()
        assertTrue(Game.getPlayers().stream().allMatch { player -> player.getDare() == null })
    }

    @Test
    fun testResetAllPoints() {
        setPlayers()
        Game.getPlayers().get(index = 1).setPoints(points = 10)
        Game.resetAllPoints()
        assertFalse(Game.getPlayers().stream().anyMatch { player -> player.getPoints() != 0 })
    }

    @Test
    fun testGetPlayersByPointsDescending() {
        setPlayers()
        setRandomPoints()
        assertTrue(
            Game.getPlayersByPointsDescending().zipWithNext()
                .all { pair -> pair.first.getPoints() >= pair.second.getPoints() })
    }

    private fun setPlayers() {
        Game.setPlayers(
            players = listOf(
                Player(name = "Alice"),
                Player(name = "Bob"),
                Player(name = "Claire"),
                Player(name = "David")
            )
        )
    }

    private fun setDare(player: Player) {
        player.setDare(dare = Dare(dare = "Do something"))
    }

    private fun setRandomPoints() {
        Game.getPlayers().stream()
            .forEach { player -> player.setPoints(points = Random.nextInt(from = 1, until = 31)) }
    }
}