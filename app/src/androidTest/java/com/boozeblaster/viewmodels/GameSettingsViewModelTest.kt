package com.boozeblaster.viewmodels

import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Player
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class GameSettingsViewModelTest {

    private val player = Player(name = "John")

    private val gameSettingsViewModel = GameSettingsViewModel()

    @Test
    fun testAdultModeInitial() {
        assertNull(gameSettingsViewModel.getAdultMode())
    }

    @Test
    fun testDifficultyInitial() {
        assertNull(gameSettingsViewModel.getDifficulty())
    }

    @Test
    fun testPlayersInitial() {
        assertEquals(emptyList<Player>(), gameSettingsViewModel.getAddedPlayers())
    }

    @Test
    fun testRoundsInitial() {
        assertEquals(0, gameSettingsViewModel.getSelectedRounds())
    }

    @Test
    fun testGetSetAdultMode() {
        gameSettingsViewModel.setAdultMode(adultMode = false)
        assertFalse(gameSettingsViewModel.getAdultMode()!!)
        gameSettingsViewModel.setAdultMode(adultMode = true)
        assertTrue(gameSettingsViewModel.getAdultMode()!!)
    }

    @Test
    fun testGetSetDifficulty() {
        gameSettingsViewModel.setDifficulty(difficulty = Difficulty.HARD)
        assertEquals(Difficulty.HARD, gameSettingsViewModel.getDifficulty())
        gameSettingsViewModel.setDifficulty(Difficulty.EASY)
        assertEquals(Difficulty.EASY, gameSettingsViewModel.getDifficulty())
    }

    @Test
    fun testGetSetPlayers() {
        gameSettingsViewModel.setPlayers(players = listOf(player))
        assertEquals(player, gameSettingsViewModel.getAddedPlayers().get(index = 0))
        assertEquals(1, gameSettingsViewModel.getAddedPlayers().size)
    }

    @Test
    fun testResetPlayers() {
        gameSettingsViewModel.setPlayers(players = listOf(player))
        gameSettingsViewModel.resetAddedPlayers()
        assertEquals(emptyList<Player>(), gameSettingsViewModel.getAddedPlayers())
    }

    @Test
    fun testGetSetRounds() {
        gameSettingsViewModel.setSelectedRounds(rounds = 3)
        assertEquals(3, gameSettingsViewModel.getSelectedRounds())
    }

}