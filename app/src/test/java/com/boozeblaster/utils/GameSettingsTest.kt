package com.boozeblaster.utils

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameSettingsTest {

    private val commonTasks = arrayOf(
        "HighestBidder", "SipTransfer", "NeverHaveIEver", "SetRule", "WhoInThisRoom"
    )
    private val versusTasks = arrayOf("RockPaperScissors", "SingASong")
    private val individualTasks =
        arrayOf("GuessTheSong", "GuessTheLyrics", "FactOrFiction")

    private val commonTasksToSet = arrayOf("NeverHaveIEver", "SetRule")
    private val individualTasksToSet = arrayOf("GuessTheSong", "GuessTheLyrics")
    private val versusTasksToSet = arrayOf("RockPaperScissors")

    @Before
    fun resetTasks() {
        GameSettings.reset()
    }

    @Test
    fun testCommonTasksInitial() {
        assertArrayEquals(commonTasks, GameSettings.getCommonTasks())
    }

    @Test
    fun testIndividualTasksInitial() {
        assertArrayEquals(individualTasks, GameSettings.getIndividualTasks())
    }

    @Test
    fun testVersusTasksInitial() {
        assertArrayEquals(versusTasks, GameSettings.getVersusTasks())
    }

    @Test
    fun testGetSetCommonTasks() {
        GameSettings.setCommonTasks(options = commonTasksToSet)
        assertArrayEquals(commonTasksToSet, GameSettings.getCommonTasks())
    }

    @Test
    fun testGetSetIndividualTasks() {
        GameSettings.setIndividualTasks(options = individualTasksToSet)
        assertArrayEquals(individualTasksToSet, GameSettings.getIndividualTasks())
    }

    @Test
    fun testGetSetVersusTasks() {
        GameSettings.setVersusTasks(options = versusTasksToSet)
        assertArrayEquals(versusTasksToSet, GameSettings.getVersusTasks())
    }

    @Test
    fun testResetCommonTasks() {
        GameSettings.setCommonTasks(options = commonTasksToSet)
        GameSettings.resetCommonTasks()
        assertArrayEquals(commonTasks, GameSettings.getCommonTasks())
    }

    @Test
    fun testResetIndividualTasks() {
        GameSettings.setIndividualTasks(options = individualTasksToSet)
        GameSettings.resetIndividualTasks()
        assertArrayEquals(individualTasks, GameSettings.getIndividualTasks())
    }

    @Test
    fun testResetVersusTasks() {
        GameSettings.setVersusTasks(options = versusTasksToSet)
        GameSettings.resetVersusTasks()
        assertArrayEquals(versusTasks, GameSettings.getVersusTasks())
    }

    @Test
    fun resetAllTasks() {
        GameSettings.setCommonTasks(options = commonTasksToSet)
        GameSettings.setIndividualTasks(options = individualTasksToSet)
        GameSettings.setVersusTasks(options = versusTasksToSet)
        GameSettings.reset()
        assertArrayEquals(commonTasks, GameSettings.getCommonTasks())
        assertArrayEquals(individualTasks, GameSettings.getIndividualTasks())
        assertArrayEquals(versusTasks, GameSettings.getVersusTasks())
    }

    @Test
    fun testPlayCommonTasks() {
        assertTrue(GameSettings.playCommonTasks())
        GameSettings.setCommonTasks(options = emptyArray())
        assertFalse(GameSettings.playCommonTasks())
        GameSettings.setCommonTasks(options = commonTasksToSet)
        assertTrue(GameSettings.playCommonTasks())
    }

    @Test
    fun testPlayIndividualTasks() {
        assertTrue(GameSettings.playIndividualTasks())
        GameSettings.setIndividualTasks(options = emptyArray())
        assertFalse(GameSettings.playIndividualTasks())
        GameSettings.setIndividualTasks(options = individualTasksToSet)
        assertTrue(GameSettings.playIndividualTasks())
    }

    @Test
    fun testPlayVersusTasks() {
        assertTrue(GameSettings.playVersusTasks())
        GameSettings.setVersusTasks(options = emptyArray())
        assertFalse(GameSettings.playVersusTasks())
        GameSettings.setVersusTasks(options = versusTasksToSet)
        assertTrue(GameSettings.playVersusTasks())
    }

    @Test
    fun testPlaySipTransfer() {
        assertTrue(GameSettings.playSipTransfer())
        GameSettings.setCommonTasks(commonTasksToSet)
        assertFalse(GameSettings.playSipTransfer())
        GameSettings.reset()
        assertTrue(GameSettings.playSipTransfer())
    }
}