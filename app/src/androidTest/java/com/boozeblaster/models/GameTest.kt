package com.boozeblaster.models

import com.boozeblaster.enums.Difficulty
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.tasks.Task
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class GameTest {

    @Before
    fun resetGame() {
        Game.reset()
    }

    @Test(expected = NoSuchMethodException::class)
    fun testGameContainsNoPublicConstructor() {
        Game::class.java.getConstructor()
        fail(
            "There should be no public constructor available in the Game class! " +
                    "Keep it a singleton object."
        )
    }

    @Test
    fun testSetPlayers() {
        setFourPlayers()
        assertEquals(4, Game.getPlayers().size)
    }

    @Test
    fun testZeroPointsAtStart() {
        setFourPlayers()
        Game.getPlayers().get(index = 1).setPoints(points = 10)
        Game.loadTasks()
        assertTrue(Game.getPlayers().stream().allMatch { player -> player.getPoints() == 0 })
    }

    @Test
    fun testResetFourPlayers() {
        setFourPlayers()
        Game.reset()
        assertEquals(0, Game.getPlayers().size)
    }

    @Test
    fun testResetAllDares() {
        setFourPlayers()
        setDare(player = Game.getPlayers().get(index = 1))
        Game.resetAllDares()
        assertTrue(Game.getPlayers().stream().allMatch { player -> player.getDare() == null })
    }

    @Test
    fun testResetAllPoints() {
        setFourPlayers()
        Game.getPlayers().get(index = 1).setPoints(points = 10)
        Game.resetAllPoints()
        assertFalse(Game.getPlayers().stream().anyMatch { player -> player.getPoints() != 0 })
    }

    @Test
    fun testGetPlayersByPointsDescending() {
        setFourPlayers()
        setRandomPoints()
        assertTrue(
            Game.getPlayersByPointsDescending().zipWithNext()
                .all { pair -> pair.first.getPoints() >= pair.second.getPoints() })
    }

    @Test
    fun testSetCorrectAmountOfLosers1() {
        setFivePlayers()
        assertEquals(2, Game.getLosers().size)
    }

    @Test
    fun testSetCorrectAmountOfLosers2() {
        setFourPlayers()
        assertEquals(1, Game.getLosers().size)
    }

    @Test
    fun testGetCorrectLosers1() {
        setFourPlayers()
        Game.getPlayers().get(index = 0).setPoints(points = 5)
        Game.getPlayers().get(index = 1).setPoints(points = 3)
        Game.getPlayers().get(index = 2).setPoints(points = 2)
        Game.getPlayers().get(index = 3).setPoints(points = 7)
        assertEquals(Game.getPlayers().get(index = 2), Game.getLosers().get(index = 0))
    }

    @Test
    fun testGetCorrectLosers2() {
        setFivePlayers()
        Game.getPlayers().get(index = 0).setPoints(points = 5)
        Game.getPlayers().get(index = 1).setPoints(points = 3)
        Game.getPlayers().get(index = 2).setPoints(points = 2)
        Game.getPlayers().get(index = 3).setPoints(points = 7)
        Game.getPlayers().get(index = 4).setPoints(points = 2)
        val losers = listOf(Game.getPlayers().get(index = 2), Game.getPlayers().get(index = 4))
        assertEquals(losers, Game.getLosers())
    }

    @Test
    fun testSetCorrectAmountOfWinners1() {
        setFourPlayers()
        assertEquals(1, Game.getWinners().size)
    }

    @Test
    fun testSetCorrectAmountOfWinners2() {
        setFivePlayers()
        assertEquals(2, Game.getWinners().size)
    }

    @Test
    fun testSetCorrectAmountOfWinners3() {
        setEightPlayers()
        assertEquals(3, Game.getWinners().size)
    }

    @Test
    fun testAdultMode() {
        Game.setAdultMode(adultMode = false)
        assertFalse(Game.isAdultMode())
        Game.setAdultMode(adultMode = true)
        assertTrue(Game.isAdultMode())
    }

    @Test
    fun testSetGetRounds() {
        Game.setRounds(rounds = 8)
        assertEquals(8, Game.getRounds())
    }

    @Test(expected = IllegalArgumentException::class)
    fun testSetRoundsShouldThrowException() {
        Game.setRounds(rounds = 11)
    }

    @Test
    fun testSipMultiplier1() {
        Game.setDifficulty(difficulty = Difficulty.EASY)
        assertEquals(1, Game.getSipMultiplier())
    }

    @Test
    fun testSipMultiplier2() {
        Game.setDifficulty(difficulty = Difficulty.MEDIUM)
        assertEquals(2, Game.getSipMultiplier())
    }

    @Test
    fun testSipMultiplier3() {
        Game.setDifficulty(difficulty = Difficulty.HARD)
        assertEquals(3, Game.getSipMultiplier())
    }

    @Test
    fun testSipMultiplier4() {
        Game.setDifficulty(difficulty = Difficulty.ALCOHOLIC)
        assertEquals(4, Game.getSipMultiplier())
    }

    @Test
    fun testGetTasks() {
        assertEquals(emptyList<Task>(), Game.getTasks())
    }

    @Test
    fun testGetTask() {
        try {
            Game.getTask(index = 0)
            fail("This should not be possible with a reset game!")
        } catch (e: Exception) {
            assertTrue(true)
        }
    }

    @Test
    fun testTasksShouldBeEmptyInitially() {
        assertEquals(0, Game.getTasks().size)
    }

    private fun setFourPlayers() {
        Game.setPlayers(
            players = listOf(
                Player(name = "Alice"),
                Player(name = "Bob"),
                Player(name = "Claire"),
                Player(name = "David")
            )
        )
    }

    private fun setFivePlayers() {
        Game.setPlayers(
            players = listOf(
                Player(name = "Alice"),
                Player(name = "Bob"),
                Player(name = "Claire"),
                Player(name = "David"),
                Player(name = "Jack")
            )
        )
    }

    private fun setEightPlayers() {
        Game.setPlayers(
            players = listOf(
                Player(name = "Alice"),
                Player(name = "Bob"),
                Player(name = "Claire"),
                Player(name = "David"),
                Player(name = "Jack"),
                Player(name = "Daniel"),
                Player(name = "Bob"),
                Player(name = "Ross")
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