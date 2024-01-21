package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.utils.GameSettings
import org.junit.Rule
import org.junit.Test

class CustomizeGameScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testCustomizeGameScreenDisplaysAllCommonTasksInitially() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            CustomizeGameScreen(navController = navController)
        }

        testComposableRule.onNodeWithText("HighestBidder").assertIsDisplayed()
        testComposableRule.onNodeWithText("SipTransfer").assertIsDisplayed()
        testComposableRule.onNodeWithText("NeverHaveIEver").assertIsDisplayed()
        testComposableRule.onNodeWithText("SetRule").assertIsDisplayed()
        testComposableRule.onNodeWithText("WhoInThisRoom").assertIsDisplayed()
    }

    @Test
    fun testCustomizeGameScreenDisplaysAllIndividualTasksInitially() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            CustomizeGameScreen(navController = navController)
        }

        testComposableRule.onNodeWithText("GuessTheSong").assertIsDisplayed()
        testComposableRule.onNodeWithText("GuessTheLyrics").assertIsDisplayed()
        testComposableRule.onNodeWithText("FactOrFiction").assertIsDisplayed()
    }

    @Test
    fun testCustomizeGameScreenDisplaysAllVersusTasksInitially() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            CustomizeGameScreen(navController = navController)
        }

        testComposableRule.onNodeWithText("RockPaperScissors").assertIsDisplayed()
        testComposableRule.onNodeWithText("SingASong").assertIsDisplayed()
    }

    /**
     * Bug found on 20/01/2024
     */
    @Test
    fun testOnBackButtonClickResetsTasksUsed() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            CustomizeGameScreen(navController = navController)
        }

        val commonTasksSize = GameSettings.getCommonTasks().size

        testComposableRule.onNodeWithText("HighestBidder").performClick()
        testComposableRule.onNodeWithText("SipTransfer").performClick()
        testComposableRule.onNodeWithText("WhoInThisRoom").performClick()

        testComposableRule.onNode(hasContentDescription("BackButton")).performClick()

        assert(GameSettings.getCommonTasks().size == commonTasksSize)
    }

}