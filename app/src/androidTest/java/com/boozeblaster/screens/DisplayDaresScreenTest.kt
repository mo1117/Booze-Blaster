package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.generators.DareTaskGenerator
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.viewmodels.GameSettingsViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DisplayDaresScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Before
    fun resetUsedDares() {
        DareTaskGenerator.resetUsedDares()
    }

    @Test
    fun testDisplayDaresScreenDisplaysAllPlayers() {
        val players = listOf(Player(name = "John"), Player(name = "Mary"))
        Game.setPlayers(players = players)
        DareTaskGenerator.assignDares(players = players)
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DisplayDaresScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("John").assertIsDisplayed()
        testComposableRule.onNodeWithText(players.get(index = 0).getDare().toString())
            .assertIsDisplayed()
        testComposableRule.onNodeWithText("Mary").assertIsDisplayed()
        testComposableRule.onNodeWithText(players.get(index = 1).getDare().toString())
            .assertIsDisplayed()
    }

    @Test
    fun testDisplayDaresScreenReloadsDare() {
        val players = listOf(Player(name = "John"))
        Game.setPlayers(players = players)
        DareTaskGenerator.assignDares(players = players)
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DisplayDaresScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        val dareText = players.get(index = 0).getDare().toString()

        testComposableRule.onNode(hasContentDescription("Reload Dare")).performClick()

        testComposableRule.onNodeWithText(dareText).assertDoesNotExist()
        testComposableRule.onNodeWithText(players.get(index = 0).getDare().toString()).assertIsDisplayed()
    }

    @Test
    fun testDisplayDaresScreenReloadsDaresOnlyIfAvailable() {
        val players = listOf(Player(name = "John"))
        Game.setPlayers(players = players)
        DareTaskGenerator.assignDares(players = players)
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DisplayDaresScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        for (i in 0..100) {
            testComposableRule.onNode(hasContentDescription("Reload Dare")).performClick()
        }

        val dareText = players.get(index = 0).getDare().toString()
        testComposableRule.onNode(hasContentDescription("Reload Dare")).performClick()
        testComposableRule.onNodeWithText(dareText).assertIsDisplayed()
    }
}